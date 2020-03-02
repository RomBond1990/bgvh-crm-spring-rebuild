package com.rbondarovich.controllers;

import com.rbondarovich.TaskService;
import com.rbondarovich.beans.TaskBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/task",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class TaskApi {

    private TaskService taskService;

    public TaskApi() {
    }

    @Autowired
    public TaskApi(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<Iterable<TaskBean>> getAllTasks() {
        Iterable<TaskBean> allTasks = taskService.getAllTasks();
        ResponseEntity<Iterable<TaskBean>> response = new ResponseEntity<>(allTasks, HttpStatus.OK);

        return response;
    }

    @GetMapping("{taskId}")
    public ResponseEntity<TaskBean> getTaskById(@PathVariable("taskId") Integer taskId) {
        TaskBean taskBean = taskService.getTaskById(taskId);
        ResponseEntity<TaskBean> response = new ResponseEntity<>(taskBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<TaskBean> saveTask (@RequestBody TaskBean taskBean) {
       taskService.saveTask(taskBean);
       ResponseEntity<TaskBean> response = new ResponseEntity<>(taskBean, HttpStatus.OK);

       return response;
    }

    @PutMapping("{taskId}")
    public ResponseEntity<Void> updateTask (@PathVariable("taskId") @RequestBody TaskBean taskBean) {
        taskService.saveTask(taskBean);

        return new ResponseEntity<>(HttpStatus.OK);
    }




}
