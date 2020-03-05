package com.rbondarovich.impl;

import com.rbondarovich.TaskService;
import com.rbondarovich.beans.TaskBean;
import com.rbondarovich.dao.ProfileDao;
import com.rbondarovich.dao.ProjectDao;
import com.rbondarovich.dao.TaskDao;
import com.rbondarovich.dao.entities.Profile;
import com.rbondarovich.dao.entities.Project;
import com.rbondarovich.dao.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    private ProfileDao profileDao;

    private ProjectDao projectDao;

    private EntityBeanConverterImpl converter;

    public TaskServiceImpl() {
    }

    @Autowired
    public TaskServiceImpl(TaskDao taskDao, ProfileDao profileDao, ProjectDao projectDao, EntityBeanConverterImpl converter) {
        this.taskDao = taskDao;
        this.profileDao = profileDao;
        this.projectDao = projectDao;
        this.converter = converter;
    }

    @Override
    public Iterable<TaskBean> getAllTasks() {
        List<Task> tasks = taskDao.findAll();
        List<TaskBean> taskBeans = converter.convertToBeanList(tasks, TaskBean.class);

        return taskBeans;
    }

    @Override
    public Iterable<TaskBean> getAllTasksByProfile(Integer profileId) {
        Profile profile = profileDao.getOne(profileId);
        List<Task> profilesTasks = taskDao.findAllByProfile(profile);
        List<TaskBean> taskBeans = converter.convertToBeanList(profilesTasks, TaskBean.class);

        return taskBeans;
    }

    @Override
    public Iterable<TaskBean> getAllTasksByProject(Integer projectId) {
        Project project = projectDao.getOne(projectId);
        List<Task> projectsTasks = taskDao.findAllByProject(project);
        List<TaskBean> taskBeans = converter.convertToBeanList(projectsTasks, TaskBean.class);

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
