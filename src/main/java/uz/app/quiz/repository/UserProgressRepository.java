package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.SpeakingTask;
import uz.app.quiz.entity.UserProgress;

import java.util.UUID;

public interface UserProgressRepository extends JpaRepository<UserProgress, UUID> {

}
