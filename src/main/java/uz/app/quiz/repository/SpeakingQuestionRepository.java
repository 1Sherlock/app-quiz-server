package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.SpeakingQuestion;

import java.util.UUID;

public interface SpeakingQuestionRepository extends JpaRepository<SpeakingQuestion, UUID> {

}
