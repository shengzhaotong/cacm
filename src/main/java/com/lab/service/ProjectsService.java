package com.lab.service;

import com.lab.dao.ProjectDao;
import com.lab.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectsService {

    @Autowired
    ProjectDao projectDao;

    public List<Project> selectAllProjects () {
        return projectDao.selectAllProjects();
    }

    public int addProject (Project project) {
        return projectDao.addProject(project);
    }

    public List<String> searchName (String key) {
        return projectDao.searchName(key);
    }

    public List<Project> searchProjects (String key) {
        return projectDao.searchProjects(key);
    }

    public int deleteProject (Project project) {
        return projectDao.deleteProject(project);
    }

}
