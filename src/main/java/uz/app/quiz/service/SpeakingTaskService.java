package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import uz.app.quiz.DTO.SpeakingQuestionDto;
import uz.app.quiz.DTO.SpeakingTaskDTO;
import uz.app.quiz.entity.SpeakingQuestion;

import uz.app.quiz.entity.SpeakingTask;
import uz.app.quiz.exception.ResourceNotFoundException;
import uz.app.quiz.repository.*;
import uz.app.quiz.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class SpeakingTaskService {
    @Autowired
    SpeakingTaskRepository speakingTaskRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    SpeakingQuestionRepository speakingQuestionRepository;


    public ResponseEntity<SpeakingTaskDTO> createSpeakingTask(SpeakingTaskDTO speakingTaskDTO) {
        SpeakingTask speakingTask;
        if (speakingTaskDTO.getTaskId() != null) {
            speakingTask = speakingTaskRepository.findById(speakingTaskDTO.getTaskId()).orElseThrow(() -> new ResourceNotFoundException("speakingTask", "id", speakingTaskDTO.getTaskId()));
        } else speakingTask = new SpeakingTask();
        speakingTask.setMainQuestion(speakingTaskDTO.getMainQuestion());
        speakingTask.setDifficulty(speakingTaskDTO.getDifficulty());
        speakingTask.setLanguage(languageRepository.findById(speakingTaskDTO.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Language", "id", speakingTaskDTO.getLanguageId())));

        speakingTask = speakingTaskRepository.save(speakingTask);
        SpeakingTask finalSpeakingTask = speakingTask;
        speakingTask.setSpeakingQuestions(speakingTaskDTO.getSpeakingQuestionDtos().stream().map(speakingQuestionDto -> getSpeakingQuestion(speakingQuestionDto, finalSpeakingTask)).collect(Collectors.toList()));
        return ResponseEntity.ok(new SpeakingTaskDTO(speakingTaskRepository.save(speakingTask)));
    }

    private SpeakingQuestion getSpeakingQuestion(SpeakingQuestionDto speakingQuestionDto, SpeakingTask speakingTask) {
        SpeakingQuestion speakingQuestion;
        if (speakingQuestionDto.getSpeakingQuestionId() != null) {
            speakingQuestion = speakingQuestionRepository.findById(speakingQuestionDto.getSpeakingQuestionId()).orElseThrow(() -> new ResourceNotFoundException("speakingTask", "id", speakingQuestionDto.getSpeakingQuestionId()));
        } else speakingQuestion = new SpeakingQuestion();
        speakingQuestion.setQuestion(speakingQuestionDto.getQuestion());
        speakingQuestion.setSpeakingTask(speakingTask);
        speakingQuestion.setSectionType(speakingQuestionDto.getSectionType());
        speakingQuestion.setTime(speakingQuestionDto.getTime());
        return speakingQuestionRepository.save(speakingQuestion);
    }


    public ResponseEntity<Page<SpeakingTaskDTO>> getSpeakingTaskPage(int page, int size) {
        return ResponseEntity.ok(speakingTaskRepository.findAll(CommonUtils.getPageable(page, size)).map(SpeakingTaskDTO::new));
    }

    public ResponseEntity<SpeakingTaskDTO> getOne(UUID id) {
        return ResponseEntity.ok(new SpeakingTaskDTO(speakingTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("speaking task", "id", id))));
    }

    public ResponseEntity<String> deleteTask(UUID id) {
        speakingTaskRepository.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
}
