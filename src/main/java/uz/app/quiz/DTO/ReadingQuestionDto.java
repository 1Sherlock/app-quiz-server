package uz.app.quiz.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.ReadingQuestion;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadingQuestionDto {

    private UUID readingQuestionId;
    private UUID readingTaskId;
    private String question;
    private List<ReadingQuestionAnswerDto> readingQuestionAnswers;
    public ReadingQuestionDto(ReadingQuestion readingQuestion) {
        this.readingQuestionId=readingQuestion.getId();
        this.readingTaskId = readingQuestion.getReadingTask()!=null?readingQuestion.getReadingTask().getId():null;
        this.question = readingQuestion.getQuestion();
        this.readingQuestionAnswers=readingQuestion.getReadingQuestionAnswers().stream().map(ReadingQuestionAnswerDto::new).collect(Collectors.toList());
    }
}
