package com.lab.service;

import com.lab.dao.PostGraduateDao;
import com.lab.pojo.Experience;
import com.lab.pojo.PostGraduate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostGraduateService {

    @Autowired
    PostGraduateDao postGraduateDao;

    @Autowired
    ExperienceService experienceService;

    public List<PostGraduate> selectAllPostGraduate () {
        List<PostGraduate> postGraduates = postGraduateDao.selectAllPostGraduate();
        if (postGraduates != null) {
            for (PostGraduate postGraduate : postGraduates) {
                postGraduate.setExperiences(experienceService.selectExperience(postGraduate.getName(),false));
            }
        }
        return postGraduates;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int addPostGraduate (PostGraduate postGraduate) {
        int num = 0;
        List<Experience> experiences = postGraduate.getExperiences();
        if (experiences != null) {
            for (Experience experience : experiences) {
                num += experienceService.addExperience(experience);
            }
        }
        num += postGraduateDao.insertPostGraduate(postGraduate);
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int updatePostGraduate (PostGraduate postGraduate) {
        int num = 0;
        List<Experience> experiences = postGraduate.getExperiences();
        if (experiences != null) {
            for (Experience experience : experiences) {
                num += experienceService.updateExperience(experience);
            }
        }
        num += postGraduateDao.updatePostGraduate(postGraduate);
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int deletePostGraduate (PostGraduate postGraduate) {
        int num = 0;
        List<Experience> experiences = postGraduate.getExperiences();
        if (experiences != null) {
            for (Experience experience : experiences) {
                num += experienceService.deleteExperience(experience);
            }
        }
        num += postGraduateDao.deletePostGraduate(postGraduate);
        return num;
    }

}
