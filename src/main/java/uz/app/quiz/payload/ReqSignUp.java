package uz.app.quiz.payload;

import lombok.Data;
import lombok.NonNull;

@Data
public class ReqSignUp {

    @NonNull
    private String password;

    @NonNull
    private String fullName;

    @NonNull
    private String passport;

    @NonNull
    private Integer workPlaceId;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String email;

}
