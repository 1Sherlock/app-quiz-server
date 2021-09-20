package uz.app.quiz.entity;

import lombok.AllArgsConstructor;
import uz.app.quiz.entity.template.AbsEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class AttachmentContent extends AbsEntity {


    private byte[] content;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "attachment_id", nullable = false)
    private Attachment attachment;


    public AttachmentContent(byte[] content,Attachment attachment) {
        this.content = content;
        this.attachment = attachment;
    }
}
