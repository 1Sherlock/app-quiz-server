package uz.app.quiz.security;

import uz.app.quiz.entity.User;
import uz.app.quiz.entity.enums.RoleName;
import uz.app.quiz.exception.BadRequestException;
import uz.app.quiz.payload.ApiResponse;
import uz.app.quiz.payload.JwtAuthenticationResponse;
import uz.app.quiz.payload.ReqSignUp;
import uz.app.quiz.payload.ResUser;
import uz.app.quiz.repository.RoleRepository;
import uz.app.quiz.repository.UserRepository;
import uz.app.quiz.repository.WorkPlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WorkPlaceRepository workPlaceRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenProvider tokenProvider;

    /**
     *
     * @param login
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByPhoneNumber(login).orElseThrow(() -> new UsernameNotFoundException(login));
    }

    public UserDetails loadUserById(UUID id, Date issuadAt) {
        try {
            Optional<User> userOptional = userRepository.findByIdAndEnabled(id, true);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                if (user.getIssuedAtJwt() == null) {
                    setIssuedAtJwt(user);
                    return user;
                }
                if (issuadAt.getTime() >= user.getIssuedAtJwt().getTime()) {
                    return user;
                }
            }
            throw new UsernameNotFoundException("User id:" + id);
        }catch (Exception e){
            return null;
        }
    }

    public HttpEntity<?> setAuth(ResUser user) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getPhoneNumber(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User userPrincipal = (User) authentication.getPrincipal();
        setIssuedAtJwt(userPrincipal);
        String jwt = tokenProvider.generateToken(userPrincipal);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, user.getUserUniqueId() != null ? user : null));
    }

    private void setIssuedAtJwt(User userPrincipal) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.set(Calendar.MILLISECOND, 0);
        userPrincipal.setIssuedAtJwt(new Timestamp(c.getTime().getTime()));
        userRepository.save(userPrincipal);
    }

    @Transactional
    public HttpEntity<?> signUp(ReqSignUp reqUserRegister) {
        try {



            int userUniqueId = (int) (10000 + userRepository.count());
            User save = userRepository.save(new User(
                    reqUserRegister.getEmail(),
                    encoder.encode(reqUserRegister.getPassword()),
                    reqUserRegister.getFullName(),
                    reqUserRegister.getPhoneNumber(),
                    userUniqueId,
                    workPlaceRepository.findById(reqUserRegister.getWorkPlaceId()).orElseThrow(()->new BadRequestException("incorrect workplace")),
                    roleRepository.findAllByName(RoleName.ROLE_USER)
                    ));
            return ResponseEntity.ok(setAuth(new ResUser(save.getPhoneNumber(),reqUserRegister.getPassword(),save.getUserUniqueId())));


        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new ApiResponse(false, "Foydalanuvchini ro'yxatga olishda xatolik"));
        }

    }

}
