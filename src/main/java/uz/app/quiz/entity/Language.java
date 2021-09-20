package uz.app.quiz.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.app.quiz.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Language extends AbsNameEntity {


}
