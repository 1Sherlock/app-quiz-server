package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.SpeakingUserAnswer;
import uz.app.quiz.entity.WritingUserAnswer;

import java.util.UUID;

public interface WritngUserAnswerRepository extends JpaRepository<WritingUserAnswer, UUID> {

}
