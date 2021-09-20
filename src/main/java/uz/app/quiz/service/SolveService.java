/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 18.09.2021
Time: 19:18
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.app.quiz.entity.*;
import uz.app.quiz.repository.*;

import java.util.List;
import java.util.UUID;
@Service
public class SolveService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserProgressRepository userProgressRepository;

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    SpeakingTaskRepository speakingTaskRepository;

    @Autowired
    ReadingTaskRepository readingTaskRepository;

    @Autowired
    WritingTaskRepository writingTaskRepository;

    @Autowired
    ListeningTaskRepository listeningTaskRepository;

    @Autowired
    GlobalConstantRepository globalConstantRepository;

    @Autowired
    ReadingQuestionRepository readingQuestionRepository;

    @Autowired
    ReadingQuestionAnswerRepository readingQuestionAnswerRepository;
    @Autowired
    ListeningQuestionRepository listeningQuestionRepository;

    @Autowired
    ListeningQuestionAnswerRepository listeningQuestionAnswerRepository;

    @Autowired
    ListeningUserAnswerRepository listeningUserAnswerRepository;

    @Autowired
    ReadingUserAnswerRepository readingUserAnswerRepository;
    @Autowired
    SpeakingQuestionRepository speakingQuestionRepository;

    public ResponseEntity<Boolean> solveReading(User user, String answer, Boolean correct, Integer orderId, UUID readingQuestionId) {
        ReadingQuestion readingQuestion = readingQuestionRepository.findById(readingQuestionId).orElseThrow(NullPointerException::new);
        boolean solved = false;
        ReadingUserAnswer readingUserAnswer = new ReadingUserAnswer(null, answer, false);
        for (ReadingQuestionAnswer readingQuestionAnswer : readingQuestion.getReadingQuestionAnswers()) {
            if (orderId.equals(readingQuestionAnswer.getOrderId())) {
                if (readingQuestionAnswer.getEqualizer() && readingQuestionAnswer.getAnswer().equals(answer)) {
                    solved = true;
                    readingUserAnswer.setIsTrue(true);
                    break;
                } else if (readingQuestionAnswer.getCheckbox() && correct.equals(readingQuestionAnswer.getCorrect())) {
                    solved = true;
                    readingUserAnswer.setAnswer("true");
                } else {
                    solved = false;
                    readingUserAnswer.setAnswer("false");
                }
            }
        }
        readingUserAnswer.setIsTrue(solved);
        readingUserAnswer = readingUserAnswerRepository.save(readingUserAnswer);
        user.getCurrentProgres().getReadingUserAnswers().add(readingUserAnswer);
        if (solved) {
            user.getCurrentProgres().setReadingScore(user.getCurrentProgres().getReadingScore() + 1);
        }
        userProgressRepository.save(user.getCurrentProgres());
        return ResponseEntity.ok(solved);
    }

    public ResponseEntity<Boolean> solveListening(User user, String answer, Boolean correct, Integer orderId, UUID listeningQuestionId) {
        ListeningQuestion listeningQuestion = listeningQuestionRepository.findById(listeningQuestionId).orElseThrow(NullPointerException::new);
        boolean solved = false;
        ListeningUserAnswer listeningUserAnswer = new ListeningUserAnswer(null, answer, false);
        for (ListeningQuestionAnswer listeningQuestionAnswer : listeningQuestion.getListeningQuestionAnswers()) {
            if (orderId.equals(listeningQuestionAnswer.getOrderId())) {
                listeningUserAnswer.setListeningQuestionAnswer(listeningQuestionAnswer);
                if (listeningQuestionAnswer.getEqualizer() && listeningQuestionAnswer.getAnswer().equals(answer)) {
                    solved = true;
                    break;
                } else if (listeningQuestionAnswer.getCheckbox() && correct.equals(listeningQuestionAnswer.getCorrect())) {
                    solved = true;
                    listeningUserAnswer.setAnswer("true");
                } else {
                    solved = false;
                    listeningUserAnswer.setAnswer("false");
                }

            }
        }
        listeningUserAnswer.setIsTrue(solved);

        List<ListeningUserAnswer> listeningUserAnswers = user.getCurrentProgres().getListeningUserAnswers();
        listeningUserAnswers.add(listeningUserAnswer);
        user.getCurrentProgres().setListeningUserAnswers(listeningUserAnswers);
        if (solved) {
            user.getCurrentProgres().setListeningScore(user.getCurrentProgres().getListeningScore() + 1);
        }
        userProgressRepository.save(user.getCurrentProgres());
        return ResponseEntity.ok(solved);
    }

    public ResponseEntity<String> solveSpeaking(User user, UUID answerAudioId, UUID speakingQuestionId) {
        SpeakingQuestion speakingQuestion = speakingQuestionRepository.findById(speakingQuestionId).orElseThrow(NullPointerException::new);
        SpeakingUserAnswer speakingUserAnswer = new SpeakingUserAnswer(
                attachmentRepository.findById(answerAudioId).orElseThrow(NullPointerException::new),
                speakingQuestion,
                user.getCurrentProgres(),
                0,
                null,
                null
        );
        user.getCurrentProgres().getSpeakingUserAnswers().add(speakingUserAnswer);
        userProgressRepository.save(user.getCurrentProgres());
        return ResponseEntity.ok("Saqlandi!");
    }

     public ResponseEntity<String> solveWriting(User user, String answerText, UUID writingTaskId) {
        WritingTask writingTask = writingTaskRepository.findById(writingTaskId).orElseThrow(NullPointerException::new);
        WritingUserAnswer writingUserAnswer = new WritingUserAnswer(answerText,writingTask, 0, null, null);
        user.getCurrentProgres().setWritingUserAnswer(writingUserAnswer);
        userProgressRepository.save(user.getCurrentProgres());
        return ResponseEntity.ok("Saqlandi!");
    }

}
