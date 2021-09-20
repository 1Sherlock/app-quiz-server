package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.app.quiz.entity.enums.FourSectionEnum;
import uz.app.quiz.entity.enums.ThreeSectionEnum;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class SpeakingQuestion extends AbsEntity {
    @Column(columnDefinition = "TEXT")
    private String question;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private SpeakingTask speakingTask;

    private Integer time;

    @Enumerated(EnumType.STRING)
    private ThreeSectionEnum sectionType;
}
