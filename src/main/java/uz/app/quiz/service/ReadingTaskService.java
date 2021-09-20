package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.app.quiz.DTO.ReadingQuestionAnswerDto;
import uz.app.quiz.DTO.ReadingQuestionDto;
import uz.app.quiz.DTO.ReadingTaskDTO;
import uz.app.quiz.entity.ReadingQuestion;
import uz.app.quiz.entity.ReadingQuestionAnswer;
import uz.app.quiz.entity.ReadingTask;
import uz.app.quiz.exception.ResourceNotFoundException;
import uz.app.quiz.repository.*;
import uz.app.quiz.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReadingTaskService {
    @Autowired
    ReadingTaskRepository readingTaskRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    ReadingQuestionRepository readingQuestionRepository;

    @Autowired
    ReadingQuestionAnswerRepository readingQuestionAnswerRepository;

    public ResponseEntity<ReadingTaskDTO> createReadingTask(ReadingTaskDTO readingTaskDTO) {
        ReadingTask readingTask;
        if (readingTaskDTO.getTaskId() != null) {
            readingTask = readingTaskRepository.findById(readingTaskDTO.getTaskId()).orElseThrow(() -> new ResourceNotFoundException("readingTask", "id", readingTaskDTO.getTaskId()));
        } else readingTask = new ReadingTask();
        readingTask.setText(readingTaskDTO.getText());
        readingTask.setDifficulty(readingTaskDTO.getDifficulty());
        readingTask.setLanguage(languageRepository.findById(readingTaskDTO.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Language", "id", readingTaskDTO.getLanguageId())));
        readingTask.setTime(readingTaskDTO.getTime());
        readingTask.setSectionType(readingTaskDTO.getSectionType());
        readingTask = readingTaskRepository.save(readingTask);
        ReadingTask finalReadingTask = readingTask;
        readingTask.setReadingQuestions(readingTaskDTO.getReadingQuestionDtos().stream().map(readingQuestionDto -> getReadingQuestionAnswer(readingQuestionDto, finalReadingTask)).collect(Collectors.toList()));
        return ResponseEntity.ok(new ReadingTaskDTO(readingTaskRepository.save(readingTask)));
    }

    private ReadingQuestion getReadingQuestionAnswer(ReadingQuestionDto readingQuestionDto, ReadingTask readingTask) {
        ReadingQuestion readingQuestion;
        if (readingQuestionDto.getReadingQuestionId() != null) {
            readingQuestion = readingQuestionRepository.findById(readingQuestionDto.getReadingQuestionId()).orElseThrow(() -> new ResourceNotFoundException("readingTask", "id", readingQuestionDto.getReadingQuestionId()));
        } else readingQuestion = new ReadingQuestion();
        readingQuestion.setQuestion(readingQuestionDto.getQuestion());
        readingQuestion.setReadingTask(readingTask);
        readingQuestion = readingQuestionRepository.save(readingQuestion);
        ReadingQuestion finalReadingQuestion = readingQuestion;
        readingQuestion.setReadingQuestionAnswers(readingQuestionDto.getReadingQuestionAnswers().stream().map(readingQuestionAnswerDto -> getReadingQuestionAnswer(readingQuestionAnswerDto, finalReadingQuestion)).collect(Collectors.toList()));
        readingTask.setAnswersCount(readingTask.getAnswersCount()+readingQuestionAnswerRepository.findFirstByReadingQuestionOrderByOrderIdDesc(readingQuestion).orElseThrow(NullPointerException::new).getOrderId());
        return readingQuestionRepository.save(readingQuestion);
    }

    private ReadingQuestionAnswer getReadingQuestionAnswer(ReadingQuestionAnswerDto readingQuestionAnswerDto, ReadingQuestion readingQuestion) {
        ReadingQuestionAnswer readingQuestionAnswer;
        if (readingQuestionAnswerDto.getReadingQuestionAnswerId() != null) {
            readingQuestionAnswer = readingQuestionAnswerRepository.findById(readingQuestionAnswerDto.getReadingQuestionAnswerId()).orElseThrow(() -> new ResourceNotFoundException("readingTask", "id", readingQuestionAnswerDto.getReadingQuestionAnswerId()));
        } else readingQuestionAnswer = new ReadingQuestionAnswer();

        readingQuestionAnswer.setAnswer(readingQuestionAnswerDto.getAnswer());
        readingQuestionAnswer.setCheckbox(readingQuestionAnswerDto.getCheckbox());
        readingQuestionAnswer.setEqualizer(readingQuestionAnswerDto.getEqualizer());
        readingQuestionAnswer.setOrderId(readingQuestionAnswerDto.getOrderId());
        readingQuestionAnswer.setCorrect(readingQuestionAnswerDto.getCorrect());

        readingQuestionAnswer.setReadingQuestion(readingQuestion);
        return readingQuestionAnswerRepository.save(readingQuestionAnswer);
    }

    public ResponseEntity<Page<ReadingTaskDTO>> getReadingTaskPage(int page, int size) {
        return ResponseEntity.ok(readingTaskRepository.findAll(CommonUtils.getPageable(page, size)).map(readingTask -> new ReadingTaskDTO(readingTask)));
    }

    public ResponseEntity<ReadingTaskDTO> getOne(UUID id) {
        return ResponseEntity.ok(new ReadingTaskDTO(readingTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("reading task", "id", id))));
    }

    public ResponseEntity<String> deleteTask(UUID id) {
        readingTaskRepository.deleteById(id);
        return ResponseEntity.ok("deleted");
    }
}
