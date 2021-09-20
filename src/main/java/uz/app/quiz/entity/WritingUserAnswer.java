package uz.app.quiz.entity;

import lombok.*;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WritingUserAnswer extends AbsEntity {

    @Column(columnDefinition = "TEXT")
    private String answer;

    @ManyToOne
    private WritingTask writingTask;

    private Integer ball;

    @Column(columnDefinition = "TEXT")
    private String description;



    @JoinColumn
    @ManyToOne
    private User checker;

}
