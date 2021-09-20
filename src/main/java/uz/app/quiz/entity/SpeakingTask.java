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
public class SpeakingTask extends AbsEntity {
    //section2 question
    @Column(columnDefinition = "TEXT")
    private String mainQuestion;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "speakingTask", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<SpeakingQuestion> speakingQuestions;

    @JoinColumn
    @ManyToOne
    private Language language;



    private Integer difficulty;
}
