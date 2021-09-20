package uz.app.quiz.projection;

import uz.app.quiz.entity.District;
import uz.app.quiz.entity.Region;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "customDistrict", types = {District.class})
public interface CustomDistrict {
    Integer getId();
    String getNameUz();
    String getNameRu();
    String getNameEn();
    CustomRegion getRegion();

}
