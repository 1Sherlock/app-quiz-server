package uz.app.quiz.controller;

import uz.app.quiz.payload.ReqSignUp;
import uz.app.quiz.payload.ReqUserSign;
import uz.app.quiz.payload.ResUser;
import uz.app.quiz.security.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     *
     * @param signUpRequest
     * @return
     */
    @PostMapping("/signUp")
    public HttpEntity<?> signUp(@RequestBody ReqSignUp signUpRequest) {
       return authService.signUp(signUpRequest);
    }

    /**
     *
     * @param signInRequest
     * @return
     */
    @PostMapping("/signIn")
    public HttpEntity<?> signIn(@RequestBody ReqUserSign signInRequest) {
        return authService.setAuth(new ResUser(signInRequest.getLogin(), signInRequest.getPassword(),null));
    }
}
