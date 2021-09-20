package uz.app.quiz.projection;

import uz.app.quiz.entity.Region;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customRegion",types = {Region.class})
public interface CustomRegion {
    Integer getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();

}
