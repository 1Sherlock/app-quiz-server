package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import uz.app.quiz.DTO.ReadingTaskDTO;
import uz.app.quiz.service.ReadingTaskService;

import java.util.UUID;

@RestController
@RequestMapping("api/reading")
public class ReadingTaskController {
    @Autowired
    ReadingTaskService readingTaskService;
    @PostMapping
    public HttpEntity<?> createReadingEditTask(@RequestBody ReadingTaskDTO readingTaskDTO){
    return readingTaskService.createReadingTask(readingTaskDTO);
    }
    @GetMapping
    public HttpEntity<?> createReadingEditTask(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
    return readingTaskService.getReadingTaskPage(page, size);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id){
    return readingTaskService.getOne(id);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
    return readingTaskService.deleteTask(id);
    }



}
