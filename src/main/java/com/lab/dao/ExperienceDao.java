package com.lab.dao;

import com.lab.pojo.Experience;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperienceDao {

    List<Experience> selectExperience(String belongTo,boolean isTeacher);
    int addExperience(Experience experience);
    int updateExperience(Experience experience);
    int deleteExperience(Experience experience);

}
