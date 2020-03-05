package com.rbondarovich.impl;

import com.rbondarovich.ProjectService;
import com.rbondarovich.beans.ProjectBean;
import com.rbondarovich.dao.ProfileDao;
import com.rbondarovich.dao.ProjectDao;
import com.rbondarovich.dao.entities.Profile;
import com.rbondarovich.dao.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;

    private ProfileDao profileDao;

    private EntityBeanConverterImpl converter;

    public ProjectServiceImpl() {
    }

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao, ProfileDao profileDao, EntityBeanConverterImpl converter) {
        this.projectDao = projectDao;
        this.profileDao = profileDao;
        this.converter = converter;
    }

    @Override
    public Iterable<ProjectBean> getAllProjects() {
        List<Project> projects = projectDao.findAll();
        List<ProjectBean> projectBeans = converter.convertToBeanList(projects, ProjectBean.class);

        return projectBeans;
    }

    @Override
    public Iterable<ProjectBean> getAllProjectsByProfile(Integer profileId) {
        Profile profile = profileDao.getOne(profileId);
        List<Project> profileProjects = projectDao.findAllByHead(profile);
        List<ProjectBean> projectBeans = converter.convertToBeanList(profileProjects, ProjectBean.class);

        return projectBeans;
    }

    @Override
    public ProjectBean getProjectById(Integer projectId) {
        Project project = projectDao.getOne(projectId);
        ProjectBean projectBean = converter.convertToBean(project, ProjectBean.class);

        return projectBean;
    }

    @Override
    public void saveProject(ProjectBean project) {
        Project projectEntity = converter.convertToEntity(project, Project.class);
        projectDao.save(projectEntity);
    }

    @Override
    public void deleteProject(Integer projectId) {
        projectDao.deleteById(projectId);
    }
}
