package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.app.quiz.entity.enums.FourSectionEnum;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class ReadingQuestion extends AbsEntity {
    //can be fully html
    @Column(columnDefinition = "TEXT")
    private String question;
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ReadingTask readingTask;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "readingQuestion", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<ReadingQuestionAnswer> readingQuestionAnswers;


}
