package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import uz.app.quiz.entity.enums.ThreeSectionEnum;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@ToString
public class ReadingTask extends AbsEntity {
    //it will be html tags with ui
    @Column(columnDefinition = "TEXT")
    private String text;

    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "readingTask", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<ReadingQuestion> readingQuestions;

    @Enumerated(EnumType.STRING)
    private ThreeSectionEnum sectionType;
    @JoinColumn
    @ManyToOne
    private Language language;
    private Integer difficulty;
    private Integer time;
    private Integer answersCount=0;
}
