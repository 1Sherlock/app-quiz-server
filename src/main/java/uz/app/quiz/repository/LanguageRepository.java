package uz.app.quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.app.quiz.entity.Language;
import uz.app.quiz.entity.Region;
import uz.app.quiz.projection.CustomLanguage;
import uz.app.quiz.projection.CustomRegion;

@RepositoryRestResource(path = "language",collectionResourceRel = "list",excerptProjection = CustomLanguage.class)
public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
