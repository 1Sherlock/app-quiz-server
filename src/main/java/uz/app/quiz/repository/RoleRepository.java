package uz.app.quiz.repository;

//import org.javers.spring.annotation.JaversSpringDataAuditable;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.app.quiz.entity.Role;
import uz.app.quiz.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.app.quiz.projection.CustomRole;

import java.util.List;
import java.util.Optional;

//@JaversSpringDataAuditable
@RepositoryRestResource(path = "role",collectionResourceRel = "list", excerptProjection = CustomRole.class)
public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findAllByName(RoleName name);



    Optional<Role> findByName(RoleName name);

    List<Role> findAllByNameIn(List<RoleName> names);


}
