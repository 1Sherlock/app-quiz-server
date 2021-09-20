package uz.app.quiz.repository;

import uz.app.quiz.entity.Region;
import uz.app.quiz.projection.CustomRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "region",collectionResourceRel = "list",excerptProjection = CustomRegion.class)
public interface RegionRepository extends JpaRepository<Region, Integer> {

}
