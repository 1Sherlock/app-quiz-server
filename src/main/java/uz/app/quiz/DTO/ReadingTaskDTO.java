package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.entity.ReadingTask;
import uz.app.quiz.entity.enums.FourSectionEnum;
import uz.app.quiz.entity.enums.ThreeSectionEnum;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingTaskDTO {
    private UUID taskId;
    private String text;
    private Integer languageId;
    private Integer difficulty;
    private ThreeSectionEnum sectionType;
    private Integer time;
    private List<ReadingQuestionDto> readingQuestionDtos;

    public ReadingTaskDTO(ReadingTask readingTask) {
        this.taskId=readingTask.getId();
        this.text = readingTask.getText();
        this.languageId = readingTask.getLanguage().getId();
        this.difficulty = readingTask.getDifficulty();
        this.sectionType = readingTask.getSectionType();
        this.time = readingTask.getTime();
        this.readingQuestionDtos = readingTask.getReadingQuestions().stream().map(ReadingQuestionDto::new).collect(Collectors.toList());
    }
}
