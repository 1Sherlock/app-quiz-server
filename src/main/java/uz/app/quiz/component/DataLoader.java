package uz.app.quiz.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.app.quiz.entity.District;
import uz.app.quiz.entity.Region;
import uz.app.quiz.entity.User;
import uz.app.quiz.entity.WorkPlace;
import uz.app.quiz.entity.enums.RoleName;
import uz.app.quiz.repository.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Value("${spring.datasource.initialization-mode}")
    private String initialMode;

    @Autowired
    UserRepository userRepository;


    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    WorkPlaceRepository workPlaceRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    DistrictRepository districtRepository;

    @Autowired
    RegionRepository regionRepository;

    /**
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        if (initialMode.equals("always")) {
            Region save = regionRepository.save(new Region("АNDIJON VILOYATI", "АNDIJON VILOYATI", "АNDIJON VILOYATI"));
            District save1 = districtRepository.save(new District("Angren", "Angren", "Angren", save));
            userRepository.save(new User("superAdmin", passwordEncoder.encode("193045"),
                    "Adminstrator", "Adminstrator",1,workPlaceRepository.save(new WorkPlace("Zavod","Zavod","Zavod",save1)),roleRepository.findAllByName(RoleName.ROLE_ADMIN)));

//            userRepository.save(new User(
//                    "+998941360100",
//                    "Jahongir",
//                    "Solijonov",
//                    "Davronjon o'g'li",
//                    "jahongirsd@mail.ru",
//                    passwordEncoder.encode("1360100"),
//                    "12345",
//                    null,
//                    roleRepository.findAllByNameIn(
//                            Arrays.asList(RoleName.ROLE_SUPER_ADMIN
//                                  ))
//                    ));


        }

     }
 }
