package uz.app.quiz.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.app.quiz.entity.Role;

@Projection(name = "customRole", types = {Role.class})
public interface CustomRole {
    Integer getId();

    String getName();

}
