package com.rbondarovich.impl;

import com.rbondarovich.TaskService;
import com.rbondarovich.beans.TaskBean;
import com.rbondarovich.dao.TaskDao;
import com.rbondarovich.dao.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    private EntityBeanConverterImpl converter;

    public TaskServiceImpl() {
    }

    @Autowired
    public TaskServiceImpl(TaskDao taskDao, EntityBeanConverterImpl converter) {
        this.taskDao = taskDao;
        this.converter = converter;
    }

    @Override
    public Iterable<TaskBean> getAllTasks() {
        List<Task> tasks = taskDao.findAll();
        List<TaskBean> taskBeans = converter.convertToBeanList(tasks, TaskBean.class);

        return taskBeans;
    }

    @Override
    public TaskBean getTaskById(Integer taskId) {
        Task task = taskDao.getOne(taskId);
        TaskBean taskBean = converter.convertToBean(task, TaskBean.class);

        return taskBean;
    }

    @Override
    public void saveTask(TaskBean task) {
        Task taskEntity = converter.convertToEntity(task, Task.class);
        taskDao.save(taskEntity);
    }

    @Override
    public void deleteTask(Integer taskId) {
        taskDao.deleteById(taskId);
    }
}
