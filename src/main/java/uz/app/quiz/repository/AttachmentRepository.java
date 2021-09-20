package uz.app.quiz.repository;

import uz.app.quiz.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
    List<Attachment> findAllByIdIn(List<UUID> ids);
    void deleteAllByIdIn(List<UUID> ids);

    List<Attachment> findAllByNameAndFileSize(String name, long size);
}
