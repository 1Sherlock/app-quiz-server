package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.ListeningQuestionAnswer;

import java.util.Optional;
import java.util.UUID;

public interface ListeningQuestionAnswerRepository extends JpaRepository<ListeningQuestionAnswer, UUID> {
    Optional<ListeningQuestionAnswer> findFirstByListeningQuestionOrderByOrderIdDesc(ListeningQuestion listeningQuestion);

}
