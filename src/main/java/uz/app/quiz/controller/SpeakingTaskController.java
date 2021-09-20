package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.app.quiz.DTO.SpeakingTaskDTO;
import uz.app.quiz.service.SpeakingTaskService;

import java.util.UUID;

@RestController
@RequestMapping("api/speaking")
public class SpeakingTaskController {
    @Autowired
    SpeakingTaskService speakingTaskService;
    @PostMapping
    public HttpEntity<?> createSpeakingEditTask(@RequestBody SpeakingTaskDTO speakingTaskDTO){
    return speakingTaskService.createSpeakingTask(speakingTaskDTO);
    }
    @GetMapping
    public HttpEntity<?> createSpeakingEditTask(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
    return speakingTaskService.getSpeakingTaskPage(page, size);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id){
    return speakingTaskService.getOne(id);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
    return speakingTaskService.deleteTask(id);
    }



}
