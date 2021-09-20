package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class ReadingQuestionAnswer extends AbsEntity {
    //can be dublicate
    private Integer orderId;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ReadingQuestion readingQuestion;
    @Column(columnDefinition = "TEXT")
    private String answer;
    private Boolean checkbox;
    private Boolean equalizer;
    private Boolean correct;

}
