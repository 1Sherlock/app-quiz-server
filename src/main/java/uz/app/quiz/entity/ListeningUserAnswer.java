package uz.app.quiz.entity;

import lombok.*;
import org.hibernate.Hibernate;
import uz.app.quiz.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString
public class ListeningUserAnswer extends AbsEntity {
    @ManyToOne
    private ListeningQuestionAnswer listeningQuestionAnswer;
    @Column(columnDefinition = "TEXT")
    private String answer;
    private Boolean isTrue;

    public ListeningUserAnswer(ListeningQuestionAnswer listeningQuestionAnswer, String answer, Boolean isTrue) {
        this.listeningQuestionAnswer = listeningQuestionAnswer;
        this.answer = answer;
        this.isTrue = isTrue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ListeningUserAnswer that = (ListeningUserAnswer) o;

        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return 1446458471;
    }
}
