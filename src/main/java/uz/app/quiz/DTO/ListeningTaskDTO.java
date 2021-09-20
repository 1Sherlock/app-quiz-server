package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.entity.enums.FourSectionEnum;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListeningTaskDTO {
    private UUID taskId;
    private UUID audioId;
    private Integer languageId;
    private Integer difficulty;
    private FourSectionEnum sectionType;
    private Integer time;
    private List<ListeningQuestionDto> listeningQuestionDtos;

    public ListeningTaskDTO(ListeningTask listeningTask) {
        this.taskId=listeningTask.getId();
        this.audioId = listeningTask.getAudio().getId();
        this.languageId = listeningTask.getLanguage().getId();
        this.difficulty = listeningTask.getDifficulty();
        this.sectionType = listeningTask.getSectionType();
        this.time = listeningTask.getTime();
        this.listeningQuestionDtos = listeningTask.getListeningQuestions().stream().map(ListeningQuestionDto::new).collect(Collectors.toList());
    }
}
