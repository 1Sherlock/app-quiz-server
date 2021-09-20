package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ListeningQuestionAnswer;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListeningQuestionAnswerDto {
    private UUID listeningQuestionAnswerId;
    private UUID listeningQuestionId;
    private Integer orderId;
    private String answer;
    private Boolean checkbox;
    private Boolean equalizer;
    private Boolean correct;

    public ListeningQuestionAnswerDto(ListeningQuestionAnswer listeningQuestionAnswer) {
        this.listeningQuestionAnswerId=listeningQuestionAnswer.getId();
        this.listeningQuestionId = listeningQuestionAnswer.getListeningQuestion()==null?null:listeningQuestionAnswer.getListeningQuestion().getId();
        this.orderId = listeningQuestionAnswer.getOrderId();
        this.answer = listeningQuestionAnswer.getAnswer();
        this.checkbox = listeningQuestionAnswer.getCheckbox();
        this.equalizer = listeningQuestionAnswer.getEqualizer();
        this.correct = listeningQuestionAnswer.getCorrect();
    }
}
