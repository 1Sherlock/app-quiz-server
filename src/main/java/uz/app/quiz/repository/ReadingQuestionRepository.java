package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.ReadingQuestion;

import java.util.UUID;

public interface ReadingQuestionRepository extends JpaRepository<ReadingQuestion, UUID> {

}
