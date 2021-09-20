package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ListeningQuestionAnswer;
import uz.app.quiz.entity.ReadingQuestionAnswer;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingQuestionAnswerDto {
    private UUID readingQuestionAnswerId;
    private UUID readingQuestionId;
    private Integer orderId;
    private String answer;
    private Boolean checkbox;
    private Boolean equalizer;
    private Boolean correct;

    public ReadingQuestionAnswerDto(ReadingQuestionAnswer readingQuestionAnswer) {
        this.readingQuestionAnswerId=readingQuestionAnswer.getId();
        this.readingQuestionId = readingQuestionAnswer.getReadingQuestion()==null?null:readingQuestionAnswer.getReadingQuestion().getId();
        this.orderId = readingQuestionAnswer.getOrderId();
        this.answer = readingQuestionAnswer.getAnswer();
        this.checkbox = readingQuestionAnswer.getCheckbox();
        this.equalizer = readingQuestionAnswer.getEqualizer();
        this.correct = readingQuestionAnswer.getCorrect();
    }
}
