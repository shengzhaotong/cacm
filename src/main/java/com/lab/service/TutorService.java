package com.lab.service;

import com.lab.dao.TutorDao;
import com.lab.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    TutorDao tutorDao;

    public List<Tutor> selectAllTutor () {
        List<Tutor> tutors = tutorDao.selectAllTutor();
        if (tutors != null) {
            for (Tutor tutor : tutors) {
                List<PartTime> partTimes = tutorDao.selectPartTime(tutor.getName());
                List<TutorProject> tutorProjects = tutorDao.selectTutorProjects(tutor.getName());
                List<Honor> honors = tutorDao.selectHonor(tutor.getName());
                List<Paper> papers = tutorDao.selectPaper(tutor.getName());
                tutor.setPartTime(partTimes);
                tutor.setProjects(tutorProjects);
                tutor.setHonor(honors);
                tutor.setPaper(papers);
            }
        }
        return tutors;
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int addTutor (Tutor tutor) {
        int num = 0;
        List<PartTime> partTimes = tutor.getPartTime();
        List<TutorProject> projects = tutor.getProjects();
        List<Honor> honors = tutor.getHonor();
        List<Paper> papers = tutor.getPaper();
        if (partTimes != null) {
            for (PartTime partTime : partTimes) {
                num += tutorDao.addPartTime(partTime);
            }
        }
        if (projects != null) {
            for (TutorProject tutorProject : projects) {
                num += tutorDao.addTutorProject(tutorProject);
            }
        }
        if (honors != null) {
            for (Honor honor : honors) {
                num += tutorDao.addHonor(honor);
            }
        }
        if (papers != null) {
            for (Paper paper : papers) {
                num += tutorDao.addPaper(paper);
            }
        }
        num += tutorDao.addTutor(tutor);
        return num;
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int updateTutor (Tutor tutor) {
        int num = 0;
        List<PartTime> partTimes = tutor.getPartTime();
        List<TutorProject> projects = tutor.getProjects();
        List<Honor> honors = tutor.getHonor();
        List<Paper> papers = tutor.getPaper();
        if (partTimes != null) {
            for (PartTime partTime : partTimes) {
                num += tutorDao.updatePartTime(partTime);
            }
        }
        if (projects != null) {
            for (TutorProject tutorProject : projects) {
                num += tutorDao.updateTutorProject(tutorProject);
            }
        }
        if (honors != null) {
            for (Honor honor : honors) {
                num += tutorDao.updateHonor(honor);
            }
        }
        if (papers != null) {
            for (Paper paper : papers) {
                num += tutorDao.updatePaper(paper);
            }
        }
        num += tutorDao.updateTutor(tutor);
        return num;
    }


    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int deleteTutor (Tutor tutor) {
        int num = 0;
        List<PartTime> partTimes = tutor.getPartTime();
        List<TutorProject> projects = tutor.getProjects();
        List<Honor> honors = tutor.getHonor();
        List<Paper> papers = tutor.getPaper();
        if (partTimes != null) {
            for (PartTime partTime : partTimes) {
                num += tutorDao.deletePartTime(partTime);
            }
        }
        if (projects != null) {
            for (TutorProject tutorProject : projects) {
                num += tutorDao.deleteTutorProject(tutorProject);
            }
        }
        if (honors != null) {
            for (Honor honor : honors) {
                num += tutorDao.deleteHonor(honor);
            }
        }
        if (papers != null) {
            for (Paper paper : papers) {
                num += tutorDao.deletePaper(paper);
            }
        }
        num += tutorDao.deleteTutor(tutor);
        return num;
    }

}
