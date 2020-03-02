package com.rbondarovich;

import com.rbondarovich.beans.TaskBean;

public interface TaskService {

    Iterable<TaskBean> getAllTasks();

    TaskBean getTaskById(Integer taskId);

    void saveTask(TaskBean task);

    void deleteTask(Integer taskId);
}
