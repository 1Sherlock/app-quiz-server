package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.WritingTask;
import uz.app.quiz.entity.enums.ThreeSectionEnum;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WritingTaskDTO {
    private UUID taskId;
    private String title;
    private Integer languageId;
    private Integer difficulty;
    private Integer time;


    public WritingTaskDTO(WritingTask writingTask) {
        this.taskId = writingTask.getId();
        this.title = writingTask.getTitle();
        this.languageId = writingTask.getLanguage().getId();
        this.difficulty = writingTask.getDifficulty();
        this.time = writingTask.getTime();
    }
}
