package uz.app.quiz.repository;

import uz.app.quiz.entity.WorkPlace;
import uz.app.quiz.projection.CustomWorkPalce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "workplace",collectionResourceRel = "list",excerptProjection = CustomWorkPalce.class)
public interface WorkPlaceRepository extends JpaRepository<WorkPlace, Integer> {

}
