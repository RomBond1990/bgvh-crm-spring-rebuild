package com.rbondarovich;

import com.rbondarovich.beans.ProjectBean;

public interface ProjectService {

    Iterable<ProjectBean> getAllProjects();

    Iterable<ProjectBean> getAllProjectsByProfile(Integer profileId);

    ProjectBean getProjectById(Integer projectId);

    void saveProject(ProjectBean project);

    void deleteProject(Integer projectId);
}
