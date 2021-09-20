package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.app.quiz.DTO.WritingTaskDTO;
import uz.app.quiz.entity.WritingTask;
import uz.app.quiz.exception.ResourceNotFoundException;
import uz.app.quiz.repository.AttachmentRepository;
import uz.app.quiz.repository.LanguageRepository;
import uz.app.quiz.repository.WritingTaskRepository;
import uz.app.quiz.utils.CommonUtils;

import java.util.UUID;

@Service
public class WritingTaskService {
    @Autowired
    WritingTaskRepository writingTaskRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    LanguageRepository languageRepository;




    public ResponseEntity<WritingTaskDTO> createWritingTask(WritingTaskDTO writingTaskDTO) {
        WritingTask writingTask;
        if (writingTaskDTO.getTaskId() != null) {
            writingTask = writingTaskRepository.findById(writingTaskDTO.getTaskId()).orElseThrow(() -> new ResourceNotFoundException("writingTask", "id", writingTaskDTO.getTaskId()));
        } else writingTask = new WritingTask();
        writingTask.setTitle(writingTaskDTO.getTitle());
        writingTask.setDifficulty(writingTaskDTO.getDifficulty());
        writingTask.setLanguage(languageRepository.findById(writingTaskDTO.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Language", "id", writingTaskDTO.getLanguageId())));

        writingTask = writingTaskRepository.save(writingTask);
        WritingTask finalWritingTask = writingTask;
        return ResponseEntity.ok(new WritingTaskDTO(writingTaskRepository.save(writingTask)));
    }

  

    public ResponseEntity<Page<WritingTaskDTO>> getWritingTaskPage(int page, int size) {
        return ResponseEntity.ok(writingTaskRepository.findAll(CommonUtils.getPageable(page, size)).map(WritingTaskDTO::new));
    }

    public ResponseEntity<WritingTaskDTO> getOne(UUID id) {
        return ResponseEntity.ok(new WritingTaskDTO(writingTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("writing task", "id", id))));
    }

    public ResponseEntity<String> deleteTask(UUID id) {
        writingTaskRepository.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
}
