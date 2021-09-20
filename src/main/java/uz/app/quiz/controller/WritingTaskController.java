package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.app.quiz.DTO.WritingTaskDTO;
import uz.app.quiz.service.WritingTaskService;

import java.util.UUID;

@RestController
@RequestMapping("api/writing")
public class WritingTaskController {
    @Autowired
    WritingTaskService writingTaskService;
    @PostMapping
    public HttpEntity<?> createWritingEditTask(@RequestBody WritingTaskDTO writingTaskDTO){
    return writingTaskService.createWritingTask(writingTaskDTO);
    }
    @GetMapping
    public HttpEntity<?> createWritingEditTask(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
    return writingTaskService.getWritingTaskPage(page, size);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id){
    return writingTaskService.getOne(id);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
    return writingTaskService.deleteTask(id);
    }



}
