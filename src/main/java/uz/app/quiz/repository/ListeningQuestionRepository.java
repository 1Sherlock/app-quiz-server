package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.Attachment;
import uz.app.quiz.entity.ListeningQuestion;

import java.util.List;
import java.util.UUID;

public interface ListeningQuestionRepository extends JpaRepository<ListeningQuestion, UUID> {

}
