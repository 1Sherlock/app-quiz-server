/* Created by IntelliJ IDEA.
 User: Mirzaahmatov Aziz
Date: 19.09.2021
Time: 15:25
 To change this template use File | Settings | File Templates.
*/
package uz.app.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.app.quiz.service.TaskService;

import java.util.UUID;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    TaskService taskService;

    @GetMapping("set-course/{userID}")
    public HttpEntity<String> setTask(@PathVariable UUID userID){
        return  ResponseEntity.ok(taskService.setTask(userID));
    }

}
