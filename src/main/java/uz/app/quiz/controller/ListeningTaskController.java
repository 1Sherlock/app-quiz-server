package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import uz.app.quiz.DTO.ListeningTaskDTO;
import uz.app.quiz.entity.ListeningTask;
import uz.app.quiz.service.ListeningTaskService;

import java.util.UUID;

@RestController
@RequestMapping("api/listening")
public class ListeningTaskController {
    @Autowired
    ListeningTaskService listeningTaskService;
    @PostMapping
    public HttpEntity<?> createListeningEditTask(@RequestBody ListeningTaskDTO listeningTaskDTO){
    return listeningTaskService.createListeningTask(listeningTaskDTO);
    }
    @GetMapping
    public HttpEntity<?> createListeningEditTask(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size){
    return listeningTaskService.getListeningTaskPage(page, size);
    }
    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable UUID id){
    return listeningTaskService.getOne(id);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable UUID id){
    return listeningTaskService.deleteTask(id);
    }



}
