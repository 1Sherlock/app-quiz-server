package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.app.quiz.entity.ReadingTask;
import uz.app.quiz.entity.SpeakingTask;

import java.awt.print.Pageable;
import java.util.Optional;
import java.util.UUID;

public interface SpeakingTaskRepository extends JpaRepository<SpeakingTask, UUID> {
    Integer countAllByDifficultyLessThanOrderByCreatedAtDesc(Integer difficulty);
    @Query(value = "select * from speaking_task  where difficulty<:difficulty  order by created_at desc limit 1 offset :offset",nativeQuery = true)
    Optional<SpeakingTask> findBydifficlty(Integer difficulty,Integer offset);


}
