package com.rbondarovich;

import com.rbondarovich.beans.TaskDurationBean;

public interface TaskDurationService {

    Iterable<TaskDurationBean> getAllTaskDurations();

    TaskDurationBean getTaskDurationById(Integer taskDurationId);

    void saveTaskDuration(TaskDurationBean taskDuration);

    void deleteTaskDuration(Integer taskDurationId);
}
