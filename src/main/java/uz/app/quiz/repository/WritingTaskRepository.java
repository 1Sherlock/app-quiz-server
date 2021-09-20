package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.entity.SpeakingTask;
import uz.app.quiz.entity.WritingTask;

import java.util.Optional;
import java.util.UUID;

public interface WritingTaskRepository extends JpaRepository<WritingTask, UUID> {
    Integer countAllByDifficultyLessThanOrderByCreatedAtDesc(Integer difficulty);
    @Query(value = "select * from writing_task  where difficulty<:difficulty  order by created_at desc limit 1 offset :offset",nativeQuery = true)
    Optional<WritingTask> findBydifficlty(Integer difficulty, Integer offset);

}
