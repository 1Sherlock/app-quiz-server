package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.app.quiz.DTO.ListeningQuestionAnswerDto;
import uz.app.quiz.DTO.ListeningQuestionDto;
import uz.app.quiz.DTO.ListeningTaskDTO;
import uz.app.quiz.entity.ListeningQuestion;
import uz.app.quiz.entity.ListeningQuestionAnswer;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.exception.ResourceNotFoundException;
import uz.app.quiz.repository.*;
import uz.app.quiz.utils.CommonUtils;

import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ListeningTaskService {
    @Autowired
    ListeningTaskRepository listeningTaskRepository;
    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    ListeningQuestionRepository listeningQuestionRepository;

    @Autowired
    ListeningQuestionAnswerRepository listeningQuestionAnswerRepository;

    public ResponseEntity<ListeningTaskDTO> createListeningTask(ListeningTaskDTO listeningTaskDTO) {
        ListeningTask listeningTask;
        if (listeningTaskDTO.getTaskId() != null) {
            listeningTask = listeningTaskRepository.findById(listeningTaskDTO.getTaskId()).orElseThrow(() -> new ResourceNotFoundException("listeningTask", "id", listeningTaskDTO.getTaskId()));
        } else listeningTask = new ListeningTask();
        listeningTask.setAudio(attachmentRepository.findById(listeningTaskDTO.getAudioId()).orElseThrow(() -> new ResourceNotFoundException("attachment", "id", listeningTaskDTO.getAudioId())));
        listeningTask.setDifficulty(listeningTaskDTO.getDifficulty());
        listeningTask.setLanguage(languageRepository.findById(listeningTaskDTO.getLanguageId()).orElseThrow(() -> new ResourceNotFoundException("Language", "id", listeningTaskDTO.getLanguageId())));
        listeningTask.setTime(listeningTaskDTO.getTime());
        listeningTask.setSectionType(listeningTaskDTO.getSectionType());
        listeningTask = listeningTaskRepository.save(listeningTask);
        ListeningTask finalListeningTask = listeningTask;
        listeningTask.setListeningQuestions(listeningTaskDTO.getListeningQuestionDtos().stream().map(listeningQuestionDto -> getListeningQuestion(listeningQuestionDto, finalListeningTask)).collect(Collectors.toList()));
        return ResponseEntity.ok(new ListeningTaskDTO(listeningTaskRepository.save(listeningTask)));
    }

    private ListeningQuestion getListeningQuestion(ListeningQuestionDto listeningQuestionDto, ListeningTask listeningTask) {
        ListeningQuestion listeningQuestion;
        if (listeningQuestionDto.getListeningQuestionId() != null) {
            listeningQuestion = listeningQuestionRepository.findById(listeningQuestionDto.getListeningQuestionId()).orElseThrow(() -> new ResourceNotFoundException("listeningTask", "id", listeningQuestionDto.getListeningQuestionId()));
        } else listeningQuestion = new ListeningQuestion();
        listeningQuestion.setQuestion(listeningQuestionDto.getQuestion());
        listeningQuestion.setListeningTask(listeningTask);
        listeningQuestion = listeningQuestionRepository.save(listeningQuestion);
        ListeningQuestion finalListeningQuestion = listeningQuestion;
        listeningQuestion.setListeningQuestionAnswers(listeningQuestionDto.getListeningQuestionAnswers().stream().map(listeningQuestionAnswerDto -> getListeningQuestionAnswer(listeningQuestionAnswerDto, finalListeningQuestion)).collect(Collectors.toList()));
        listeningTask.setAnswersCount(listeningTask.getAnswersCount()+listeningQuestionAnswerRepository.findFirstByListeningQuestionOrderByOrderIdDesc(listeningQuestion).orElseThrow(NullPointerException::new).getOrderId());
        return listeningQuestionRepository.save(listeningQuestion);
    }

    private ListeningQuestionAnswer getListeningQuestionAnswer(ListeningQuestionAnswerDto listeningQuestionAnswerDto, ListeningQuestion listeningQuestion) {
        ListeningQuestionAnswer listeningQuestionAnswer;
        if (listeningQuestionAnswerDto.getListeningQuestionAnswerId() != null) {
            listeningQuestionAnswer = listeningQuestionAnswerRepository.findById(listeningQuestionAnswerDto.getListeningQuestionAnswerId()).orElseThrow(() -> new ResourceNotFoundException("listeningTask", "id", listeningQuestionAnswerDto.getListeningQuestionAnswerId()));
        } else listeningQuestionAnswer = new ListeningQuestionAnswer();

        listeningQuestionAnswer.setAnswer(listeningQuestionAnswerDto.getAnswer());
        listeningQuestionAnswer.setCheckbox(listeningQuestionAnswerDto.getCheckbox());
        listeningQuestionAnswer.setEqualizer(listeningQuestionAnswerDto.getEqualizer());
        listeningQuestionAnswer.setOrderId(listeningQuestionAnswerDto.getOrderId());
        listeningQuestionAnswer.setCorrect(listeningQuestionAnswerDto.getCorrect());

        listeningQuestionAnswer.setListeningQuestion(listeningQuestion);
        return listeningQuestionAnswerRepository.save(listeningQuestionAnswer);
    }
    public ResponseEntity<Page<ListeningTaskDTO>> getListeningTaskPage(int page, int size){
        return  ResponseEntity.ok(listeningTaskRepository.findAll(CommonUtils.getPageable(page, size)).map(listeningTask -> new ListeningTaskDTO(listeningTask)));
    }
    public ResponseEntity<ListeningTaskDTO> getOne(UUID id){
        return  ResponseEntity.ok(new ListeningTaskDTO(listeningTaskRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Listening task","id",id))));
    }
    public ResponseEntity<String> deleteTask(UUID id){
        listeningTaskRepository.deleteById(id);
        return  ResponseEntity.ok("deleted");
    }
}
