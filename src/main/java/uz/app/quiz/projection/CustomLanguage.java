package uz.app.quiz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.app.quiz.entity.Language;
import uz.app.quiz.entity.Region;

@Projection(name = "customLanguage",types = {Language.class})
public interface CustomLanguage {
    Integer getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();

}
