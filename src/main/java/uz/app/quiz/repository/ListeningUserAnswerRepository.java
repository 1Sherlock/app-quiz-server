package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.entity.ListeningUserAnswer;

import java.util.UUID;

public interface ListeningUserAnswerRepository extends JpaRepository<ListeningUserAnswer, UUID> {

}
