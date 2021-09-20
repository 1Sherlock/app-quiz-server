package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.SpeakingQuestion;
import uz.app.quiz.entity.enums.ThreeSectionEnum;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakingQuestionDto {

    private UUID speakingQuestionId;
    private UUID speakingTaskId;
    private String question;
    private ThreeSectionEnum sectionType;
    private Integer time;
    public SpeakingQuestionDto(SpeakingQuestion speakingQuestion) {
        this.speakingQuestionId=speakingQuestion.getId();
        this.speakingTaskId = speakingQuestion.getSpeakingTask()!=null?speakingQuestion.getSpeakingTask().getId():null;
        this.question = speakingQuestion.getQuestion();
        this.sectionType = speakingQuestion.getSectionType();
        this.time = speakingQuestion.getTime();
   }
}
