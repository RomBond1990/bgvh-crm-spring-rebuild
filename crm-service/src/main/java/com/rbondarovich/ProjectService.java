package com.rbondarovich;

import com.rbondarovich.beans.ProjectBean;

public interface ProjectService {

    Iterable<ProjectBean> getAllProjects();

    ProjectBean getProjectById(Integer projectId);

    void saveProject(ProjectBean project);

    void deleteProject(Integer projectId);
}
