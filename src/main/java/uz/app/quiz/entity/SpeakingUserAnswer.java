package uz.app.quiz.entity;

import ch.qos.logback.core.joran.spi.NoAutoStart;
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
public class SpeakingUserAnswer extends AbsEntity {
    @JoinColumn
    @ManyToOne
    private Attachment audio;
    @JoinColumn
    @ManyToOne
    private SpeakingQuestion speakingQuestion;
    @JoinColumn
    @ManyToOne
    private UserProgress userProgress;


    private Integer ball;
    @Column(columnDefinition = "TEXT")
    private String description;

    @JoinColumn
    @ManyToOne
    private User checker;
}
