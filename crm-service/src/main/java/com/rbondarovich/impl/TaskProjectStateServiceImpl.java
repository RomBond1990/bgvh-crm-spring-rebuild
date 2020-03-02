package com.rbondarovich.impl;

import com.rbondarovich.TaskProjectStateService;
import com.rbondarovich.beans.TaskProjectStateBean;
import com.rbondarovich.dao.TaskProjectStateDao;
import com.rbondarovich.dao.entities.TaskProjectState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskProjectStateServiceImpl implements TaskProjectStateService {


    private TaskProjectStateDao taskProjectStateDao;

    private EntityBeanConverterImpl converter;

    public TaskProjectStateServiceImpl() {
    }

    @Autowired
    public TaskProjectStateServiceImpl(TaskProjectStateDao taskProjectStateDao, EntityBeanConverterImpl converter) {
        this.taskProjectStateDao = taskProjectStateDao;
        this.converter = converter;
    }

    @Override
    public Iterable<TaskProjectStateBean> getAllTaskProjectStates() {
        List<TaskProjectState> taskProjectStates = taskProjectStateDao.findAll();
        List<TaskProjectStateBean> taskProjectStateBeans = converter.convertToBeanList(taskProjectStates, TaskProjectStateBean.class);

        return taskProjectStateBeans;
    }

    @Override
    public TaskProjectStateBean getTaskProjectStateById(Integer taskProjectStateId) {
        TaskProjectState task = taskProjectStateDao.getOne(taskProjectStateId);
        TaskProjectStateBean taskBean = converter.convertToBean(task, TaskProjectStateBean.class);

        return taskBean;
    }

    @Override
    public void saveTaskProjectState(TaskProjectState taskProjectState) {
        TaskProjectState taskEntity = converter.convertToEntity(taskProjectState, TaskProjectState.class);
        taskProjectStateDao.save(taskEntity);
    }

    @Override
    public void deleteTaskProjectState(Integer taskProjectStateId) {
        taskProjectStateDao.deleteById(taskProjectStateId);
    }
}
