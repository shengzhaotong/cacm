package com.lab.controller;

import com.lab.pojo.Project;
import com.lab.service.ProjectsService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    @Autowired
    ProjectsService projectsService;

    @Autowired
    JsonUtil jsonUtil;

    @GetMapping("/get_all_projects")
    public String getAllProjects () {
        return jsonUtil.getJson(projectsService.selectAllProjects());
    }

    @PostMapping("/add_project")
    public int addProject (@RequestBody Project project) {
        return projectsService.addProject(project);
    }

    @GetMapping("/search_name")
    public String searchTitle (String key) {
        return jsonUtil.getJson(projectsService.searchName(key));
    }

    @GetMapping("/search_project")
    public String searchProject (String key) {
        return jsonUtil.getJson(projectsService.searchProjects(key));
    }

    @PostMapping("/delete_project")
    public int deleteProject (@RequestBody Project project) {
        return projectsService.deleteProject(project);
    }

}
