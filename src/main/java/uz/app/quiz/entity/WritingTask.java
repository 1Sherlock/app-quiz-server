package uz.app.quiz.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class WritingTask extends AbsEntity {
    @Column(columnDefinition = "TEXT")
    private String title;
    @JoinColumn
    @ManyToOne
    private Language language;

    private Integer time;
    private Integer difficulty;
}
