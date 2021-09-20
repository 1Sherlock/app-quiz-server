package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ReadingTask;
import uz.app.quiz.entity.SpeakingTask;
import uz.app.quiz.entity.enums.ThreeSectionEnum;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpeakingTaskDTO {
    private UUID taskId;
    private String mainQuestion;
    private Integer languageId;
    private Integer difficulty;
    private Integer time;
    private List<SpeakingQuestionDto> speakingQuestionDtos;

    public SpeakingTaskDTO(SpeakingTask speakingTask) {
        this.taskId=speakingTask.getId();
        this.mainQuestion = speakingTask.getMainQuestion();
        this.languageId = speakingTask.getLanguage().getId();
        this.difficulty = speakingTask.getDifficulty();
        this.speakingQuestionDtos = speakingTask.getSpeakingQuestions().stream().map(SpeakingQuestionDto::new).collect(Collectors.toList());
    }
}
