package com.rbondarovich.impl;

import com.rbondarovich.TaskDurationService;
import com.rbondarovich.beans.TaskDurationBean;
import com.rbondarovich.dao.TaskDurationDao;
import com.rbondarovich.dao.entities.TaskDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskDurationServiceImpl implements TaskDurationService {

    private TaskDurationDao taskDurationDao;

    private EntityBeanConverterImpl converter;

    public TaskDurationServiceImpl() {
    }

    @Autowired
    public TaskDurationServiceImpl(TaskDurationDao taskDurationDao, EntityBeanConverterImpl converter) {
        this.taskDurationDao = taskDurationDao;
        this.converter = converter;
    }

    @Override
    public Iterable<TaskDurationBean> getAllTaskDurations() {
        List<TaskDuration> taskDurations = taskDurationDao.findAll();
        List<TaskDurationBean> taskDurationBeans = converter.convertToBeanList(taskDurations, TaskDurationBean.class);

        return taskDurationBeans;
    }

    @Override
    public TaskDurationBean getTaskDurationById(Integer taskDurationId) {
        TaskDuration taskDuration = taskDurationDao.getOne(taskDurationId);
        TaskDurationBean taskDurationBean = converter.convertToBean(taskDuration, TaskDurationBean.class);

        return taskDurationBean;
    }

    @Override
    public void saveTaskDuration(TaskDurationBean taskDuration) {
        TaskDuration taskDurationEntity = converter.convertToEntity(taskDuration, TaskDuration.class);
        taskDurationDao.save(taskDurationEntity);
    }

    @Override
    public void deleteTaskDuration(Integer taskDurationId) {
        taskDurationDao.deleteById(taskDurationId);
    }
}
