package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class GlobalConstant extends AbsEntity {
   private Integer minBallToRetry;
   private Integer maxHardness;

}
