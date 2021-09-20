/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 19.09.2021
Time: 16:00
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqSolveWriting {
    private String answerText;
    private UUID writingTaskId;
}
