package com.rbondarovich;

import com.rbondarovich.beans.TaskProjectStateBean;
import com.rbondarovich.dao.entities.TaskProjectState;

public interface TaskProjectStateService {

    Iterable<TaskProjectStateBean> getAllTaskProjectStates();

    TaskProjectStateBean getTaskProjectStateById(Integer taskProjectStateId);

    void saveTaskProjectState (TaskProjectState taskProjectState);

    void deleteTaskProjectState(Integer taskProjectStateId);
}
