package uz.app.quiz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


/**
 * Created by Sirojov on 21.01.2019.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqUserSign {
    @NonNull
    private String login;
    @NonNull
    private String password;
}
