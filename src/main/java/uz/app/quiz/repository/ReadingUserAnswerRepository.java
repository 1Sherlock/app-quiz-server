package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ListeningUserAnswer;
import uz.app.quiz.entity.ReadingUserAnswer;

import java.util.UUID;

public interface ReadingUserAnswerRepository extends JpaRepository<ReadingUserAnswer, UUID> {

}
