package com.rbondarovich.controllers;

import com.rbondarovich.TaskService;
import com.rbondarovich.beans.TaskBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/tasks",
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

    @GetMapping("/profiles/{profileId}")
    public ResponseEntity<Iterable<TaskBean>> getAllTasksByProfile(@PathVariable("profileId") Integer
                                                                           profileId) {
        Iterable<TaskBean> profilesTasks = taskService.getAllTasksByProfile(profileId);
        ResponseEntity<Iterable<TaskBean>> response = new ResponseEntity<>(profilesTasks, HttpStatus.OK);

        return response;
    }

    @GetMapping("/projects/{projectId}")
    public ResponseEntity<Iterable<TaskBean>> getAllTasksByProject(@PathVariable("projectId") Integer projectId) {
        Iterable<TaskBean> projectsTasks = taskService.getAllTasksByProject(projectId);
        ResponseEntity<Iterable<TaskBean>> response = new ResponseEntity<>(projectsTasks, HttpStatus.OK);

        return response;
    }

    @GetMapping("{taskId}")
    public ResponseEntity<TaskBean> getTaskById(@PathVariable("taskId") Integer taskId) {
        TaskBean taskBean = taskService.getTaskById(taskId);
        ResponseEntity<TaskBean> response = new ResponseEntity<>(taskBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<TaskBean> saveTask(@RequestBody TaskBean taskBean) {
        taskService.saveTask(taskBean);
        ResponseEntity<TaskBean> response = new ResponseEntity<>(taskBean, HttpStatus.OK);

        return response;
    }

    @PutMapping("{taskId}")
    public ResponseEntity<Void> updateTask(@PathVariable("taskId") TaskBean taskBeanFromDB, @RequestBody TaskBean taskBean) {

        BeanUtils.copyProperties(taskBean, taskBeanFromDB);
        taskService.saveTask(taskBeanFromDB);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Integer taskId) {
        taskService.deleteTask(taskId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
