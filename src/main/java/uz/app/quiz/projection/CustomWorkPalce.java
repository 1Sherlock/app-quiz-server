package uz.app.quiz.projection;

import uz.app.quiz.entity.WorkPlace;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customWorkPlace",types = {WorkPlace.class})
public interface CustomWorkPalce {
    Integer getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();

}
