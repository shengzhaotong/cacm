package com.lab.dao;

import com.lab.pojo.Project;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProjectDao {

    List<Project> selectAllProjects();
    int addProject(Project project);
    String searchName(String key);
    List<Project> searchProjects(String key);
    int deleteProject(Project project);

}
