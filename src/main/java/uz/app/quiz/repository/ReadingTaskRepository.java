package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.entity.ReadingTask;
import uz.app.quiz.entity.SpeakingTask;
import uz.app.quiz.entity.enums.ThreeSectionEnum;

import java.util.Optional;
import java.util.UUID;

public interface ReadingTaskRepository extends JpaRepository<ReadingTask, UUID> {
    Integer countAllByDifficultyLessThanAndSectionTypeOrderByCreatedAtDesc(Integer difficulty, ThreeSectionEnum sectionType);
    @Query(value = "select * from reading_task  where difficulty<:difficulty and section_type=:sectionType  order by created_at desc limit 1 offset :offset",nativeQuery = true)
    Optional<ReadingTask> findBydifficlty(Integer difficulty, Integer offset,ThreeSectionEnum sectionType);

}
