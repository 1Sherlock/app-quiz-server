package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.Hibernate;
import uz.app.quiz.entity.enums.FourSectionEnum;
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
public class ListeningTask extends AbsEntity {
    @JoinColumn
    @ManyToOne
    private Attachment audio;


    @Enumerated(EnumType.STRING)
    private FourSectionEnum sectionType;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listeningTask", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<ListeningQuestion> listeningQuestions=new ArrayList<>();

    @JoinColumn
    @ManyToOne
    private Language language;
    private Integer difficulty;
    private Integer time;
    private Integer answersCount=0;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ListeningTask that = (ListeningTask) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 526046815;
    }
}
