/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 28.08.2021
Time: 16:05
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.entity;

import lombok.AllArgsConstructor;
import uz.app.quiz.entity.template.AbsNameEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class WorkPlace extends AbsNameEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private District district;

    public WorkPlace( String nameUz, String nameRu, String nameEn, District district) {
        super(nameUz, nameRu, nameEn);
        this.district = district;
    }

    public WorkPlace() {

    }
}
