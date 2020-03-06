package com.rbondarovich;

import com.rbondarovich.beans.TaskBean;

public interface TaskService {

    Iterable<TaskBean> getAllTasks();

    Iterable<TaskBean> getAllTasksByProfile(Integer profileId);

    Iterable<TaskBean> getAllTasksByProject(Integer projectId);

    Iterable<TaskBean> getAllTasksByTaskParent(Integer taskParentId);

    TaskBean getTaskById(Integer taskId);

    void saveTask(TaskBean task);

    void deleteTask(Integer taskId);

}
