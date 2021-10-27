package com.lab.service;

import com.lab.dao.ExperienceDao;
import com.lab.pojo.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    ExperienceDao experienceDao;

    public List<Experience> selectExperience (String belongTo,boolean isTeacher) {
        return experienceDao.selectExperience(belongTo,isTeacher);
    }

    public int addExperience (Experience experience) {
        return experienceDao.addExperience(experience);
    }

    public int updateExperience (Experience experience) {
        return experienceDao.updateExperience(experience);
    }

    public int deleteExperience (Experience experience) {
        return experienceDao.deleteExperience(experience);
    }

}
