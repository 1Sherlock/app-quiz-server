package uz.app.quiz.repository;

import uz.app.quiz.entity.District;
import uz.app.quiz.projection.CustomDistrict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource(path = "district",collectionResourceRel = "list",excerptProjection = CustomDistrict.class)
public interface DistrictRepository extends JpaRepository<District, Integer> {
//    @PreAuthorize(value = "permitAll()")
    @RestResource(path = "/findByRegionId")
    List<District> findAllByRegion_id(@Param("id") Integer id);



}
