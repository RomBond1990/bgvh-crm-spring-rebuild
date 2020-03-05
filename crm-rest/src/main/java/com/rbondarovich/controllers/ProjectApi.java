package com.rbondarovich.controllers;

import com.rbondarovich.ProjectService;
import com.rbondarovich.beans.ProjectBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/projects",
                consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjectApi {

    private ProjectService projectService;

    public ProjectApi() {
    }

    @Autowired
    public ProjectApi(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<Iterable<ProjectBean>> getAllProjects(){
        Iterable<ProjectBean> allProjects = projectService.getAllProjects();
        ResponseEntity<Iterable<ProjectBean>> response = new ResponseEntity<>(allProjects, HttpStatus.OK);

        return response;
    }

    @GetMapping("/profiles/{profileId}")
    public ResponseEntity<Iterable<ProjectBean>> getAllProjectsByProfile(@PathVariable("profileId") Integer profileId) {
        Iterable<ProjectBean> profilesProjects = projectService.getAllProjectsByProfile(profileId);
        ResponseEntity<Iterable<ProjectBean>> response = new ResponseEntity<>(profilesProjects, HttpStatus.OK);

        return response;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectBean> getProjectById (@PathVariable("projectId") Integer projectId){
        ProjectBean projectBean = projectService.getProjectById(projectId);
        ResponseEntity<ProjectBean> response = new ResponseEntity<>(projectBean, HttpStatus.OK);

        return response;
    }

    @PostMapping
    public ResponseEntity<ProjectBean> saveProject (@RequestBody ProjectBean projectBean) {
        projectService.saveProject(projectBean);
        ResponseEntity<ProjectBean> response = new ResponseEntity<>(projectBean, HttpStatus.OK);

        return response;
    }

}
