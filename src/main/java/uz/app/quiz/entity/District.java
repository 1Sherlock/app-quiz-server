package uz.app.quiz.entity;

import uz.app.quiz.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class District extends AbsNameEntity {
    public District(String nameUz, String nameRu, String nameEn, Region region) {
        super(nameUz, nameRu, nameEn);
        this.region = region;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Region region;

}
