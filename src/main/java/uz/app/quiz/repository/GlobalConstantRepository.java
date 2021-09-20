package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.app.quiz.entity.GlobalConstant;
import uz.app.quiz.entity.Region;
import uz.app.quiz.projection.CustomRegion;

import java.util.Optional;

@RepositoryRestResource(path = "global-constant",collectionResourceRel = "list")
public interface GlobalConstantRepository extends JpaRepository<GlobalConstant, Integer> {
    Optional<GlobalConstant> findFirstByOrderByCreatedAtDesc();
}
