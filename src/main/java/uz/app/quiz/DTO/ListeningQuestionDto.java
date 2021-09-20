package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ListeningQuestion;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListeningQuestionDto {

    private UUID listeningQuestionId;
    private UUID listeningTaskId;
    private String question;
    private List<ListeningQuestionAnswerDto> listeningQuestionAnswers;
    public ListeningQuestionDto(ListeningQuestion listeningQuestion) {
        this.listeningQuestionId=listeningQuestion.getId();
        this.listeningTaskId = listeningQuestion.getListeningTask()!=null?listeningQuestion.getListeningTask().getId():null;
        this.question = listeningQuestion.getQuestion();
        this.listeningQuestionAnswers=listeningQuestion.getListeningQuestionAnswers().stream().map(ListeningQuestionAnswerDto::new).collect(Collectors.toList());
    }
}
