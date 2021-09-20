package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.app.quiz.entity.enums.FourSectionEnum;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class ListeningQuestionAnswer extends AbsEntity {
    //can be dublicate
    private Integer orderId;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    private ListeningQuestion listeningQuestion;
    @Column(columnDefinition = "TEXT")
    private String answer;
    private Boolean checkbox;
    private Boolean equalizer;
    private Boolean correct;
}
