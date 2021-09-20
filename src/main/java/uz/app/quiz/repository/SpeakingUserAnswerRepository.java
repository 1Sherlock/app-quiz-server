package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ReadingUserAnswer;
import uz.app.quiz.entity.SpeakingUserAnswer;

import java.util.UUID;

public interface SpeakingUserAnswerRepository extends JpaRepository<SpeakingUserAnswer, UUID> {

}
