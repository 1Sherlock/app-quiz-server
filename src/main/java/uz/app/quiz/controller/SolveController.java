/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 19.09.2021
Time: 15:52
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.app.quiz.entity.User;
import uz.app.quiz.payload.ReqSolveListening;
import uz.app.quiz.payload.ReqSolveReading;
import uz.app.quiz.payload.ReqSolveSpeaking;
import uz.app.quiz.payload.ReqSolveWriting;
import uz.app.quiz.security.CurrentUser;
import uz.app.quiz.service.SolveService;

@RestController
@RequestMapping("api/solve")
public class SolveController {
    @Autowired
    SolveService solveService;

    @PostMapping("reading")
    public HttpEntity<Boolean> solveReading(@CurrentUser User user, @RequestBody ReqSolveReading reqSolveReading) {
        return solveService.solveReading(user,reqSolveReading.getAnswer(),reqSolveReading.getCorrect(),reqSolveReading.getOrderId(),reqSolveReading.getReadingQuestionId());
    }
    @PostMapping("listening")
    public HttpEntity<Boolean> solveListening(@CurrentUser User user, @RequestBody ReqSolveListening reqSolveListening) {
        return solveService.solveListening(user,reqSolveListening.getAnswer(),reqSolveListening.getCorrect(),reqSolveListening.getOrderId(),reqSolveListening.getListeningQuestionId());
    }
    @PostMapping("speaking")
    public HttpEntity<String> solveSpeaking(@CurrentUser User user, @RequestBody ReqSolveSpeaking reqSolveSpeaking) {
        return solveService.solveSpeaking(user,reqSolveSpeaking.getAnswerAudioId(),reqSolveSpeaking.getSpeakingQuestionId());
    }
    @PostMapping("writing")
    public HttpEntity<String> solveWriting(@CurrentUser User user, @RequestBody ReqSolveWriting reqSolveWriting) {
        return solveService.solveWriting(user,reqSolveWriting.getAnswerText(),reqSolveWriting.getWritingTaskId());
    }
}
