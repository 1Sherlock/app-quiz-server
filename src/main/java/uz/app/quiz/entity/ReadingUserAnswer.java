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
public class ReadingUserAnswer extends AbsEntity {
    @JoinColumn
    @ManyToOne
    private ReadingQuestionAnswer readingQuestionAnswer;
    @Column(columnDefinition = "TEXT")
    private String answer;
    private Boolean isTrue;
}
