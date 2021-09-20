package uz.app.quiz.entity;

import lombok.NoArgsConstructor;
import uz.app.quiz.entity.template.AbsNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Region extends AbsNameEntity {

    public Region(String nameUz, String nameRu, String nameEn) {
        super(nameUz, nameRu, nameEn);
    }
}
