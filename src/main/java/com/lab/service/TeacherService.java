package com.lab.service;

import com.lab.dao.TeacherDao;
import com.lab.dao.TutorDao;
import com.lab.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService {

    @Autowired
    TeacherDao teacherDao;

    @Autowired
    TutorDao tutorDao;

    @Autowired
    ExperienceService experienceService;

    public List<Teacher> selectAllTeacher () {
        List<Teacher> teachers = teacherDao.selectAllTeacher();
        if (teachers != null) {
            for (Teacher teacher : teachers) {
                teacher.setExperiences(experienceService.selectExperience(teacher.getName(), true));
                teacher.setPapers(tutorDao.selectPaper(teacher.getName()));
                teacher.setProjects(tutorDao.selectTutorProjects(teacher.getName()));
            }
        }
        return teachers;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int insertTeacher (Teacher teacher) {
        int num = 0;
        List<Experience> experiences = teacher.getExperiences();
        List<TutorProject> projects = teacher.getProjects();
        List<Paper> papers = teacher.getPapers();
        if (experiences != null) {
            for (Experience experience : experiences) {
                num += experienceService.addExperience(experience);
            }
        }
        if (projects != null) {
            for (TutorProject project : projects) {
                num += tutorDao.addTutorProject(project);
            }
        }
        if (papers != null) {
            for (Paper paper : papers) {
                num += tutorDao.addPaper(paper);
            }
        }
        num += teacherDao.addTeacher(teacher);
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int updateTeacher (Teacher teacher) {
        int num = 0;
        List<Experience> experiences = teacher.getExperiences();
        List<TutorProject> projects = teacher.getProjects();
        List<Paper> papers = teacher.getPapers();
        if (experiences != null) {
            for (Experience experience : experiences) {
                num += experienceService.updateExperience(experience);
            }
        }
        if (projects != null) {
            for (TutorProject project : projects) {
                num += tutorDao.updateTutorProject(project);
            }
        }
        if (papers != null) {
            for (Paper paper : papers) {
                num += tutorDao.updatePaper(paper);
            }
        }
        num += teacherDao.updateTeacher(teacher);
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int deleteTeacher (Teacher teacher) {
        int num = 0;
        List<Experience> experiences = teacher.getExperiences();
        List<TutorProject> projects = teacher.getProjects();
        List<Paper> papers = teacher.getPapers();
        if (experiences != null) {
            for (Experience experience : experiences) {
                num += experienceService.deleteExperience(experience);
            }
        }
        if (projects != null) {
            for (TutorProject project : projects) {
                num += tutorDao.deleteTutorProject(project);
            }
        }
        if (papers != null) {
            for (Paper paper : papers) {
                num += tutorDao.deletePaper(paper);
            }
        }
        num += teacherDao.deleteTeacher(teacher);
        return num;
    }

}
