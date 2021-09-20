package uz.app.quiz.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
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
public class ListeningQuestion extends AbsEntity {
    //can be fully html
    @Column(columnDefinition = "TEXT")
    private String question;
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "listeningQuestion", cascade = CascadeType.REMOVE)
    @ToString.Exclude
    private List<ListeningQuestionAnswer> listeningQuestionAnswers=new ArrayList<>();

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private ListeningTask listeningTask;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ListeningQuestion that = (ListeningQuestion) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1320548480;
    }
}
