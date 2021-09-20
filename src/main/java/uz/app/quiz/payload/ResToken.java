/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 14.08.2021
Time: 14:31
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResToken {
    private String token_type;
    private String expires_in;
    private String access_token;
    private String refresh_token;
}
