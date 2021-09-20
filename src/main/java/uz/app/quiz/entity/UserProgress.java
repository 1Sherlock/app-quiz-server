package uz.app.quiz.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString
public class UserProgress extends AbsEntity {
    @OneToOne
    private User user;
    @ManyToOne
    private UserProgress parentProgress;
    @ManyToMany
    @ToString.Exclude
    private List<ReadingTask> readingTask;
    @ManyToMany
    @ToString.Exclude
    private List<ListeningTask> listeningTasks;
    @ManyToOne
    private WritingTask writingTask;
    @ManyToOne
    private SpeakingTask speakingTask;


    @ManyToOne
    private WritingUserAnswer writingUserAnswer;
    @OneToMany
    @ToString.Exclude
    private List<SpeakingUserAnswer> speakingUserAnswers=new ArrayList<>();
    @OneToMany
    @ToString.Exclude
    private List<ListeningUserAnswer> listeningUserAnswers=new ArrayList<>();
    @OneToMany
    @ToString.Exclude
    private List<ReadingUserAnswer> readingUserAnswers=new ArrayList<>();


    private Integer writingScore=0;
    private Integer speakingScore=0;
    private Integer listeningScore=0;
    private Integer readingScore=0;

    private Boolean readingReplayed;
    private Boolean writeingReplayed;
    private Boolean listeningReplayed;
    private Boolean speakingReplayed;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserProgress that = (UserProgress) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 318572784;
    }
}
