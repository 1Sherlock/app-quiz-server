package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.ListeningQuestionAnswer;
import uz.app.quiz.entity.ReadingQuestion;
import uz.app.quiz.entity.ReadingQuestionAnswer;

import java.util.Optional;
import java.util.UUID;

public interface ReadingQuestionAnswerRepository extends JpaRepository<ReadingQuestionAnswer, UUID> {
    Optional<ReadingQuestionAnswer> findFirstByReadingQuestionOrderByOrderIdDesc(ReadingQuestion readingQuestion);

}
