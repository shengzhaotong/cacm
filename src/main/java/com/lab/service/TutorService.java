package com.lab.service;

import com.lab.dao.TutorDao;
import com.lab.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorService {

    @Autowired
    TutorDao tutorDao;

    public List<Tutor> selectAllTutor () {
        List<Tutor> tutors = tutorDao.selectAllTutor();
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
        return tutors;
    }

    public int addTutor (Tutor tutor) {
        int num = 0;
        List<PartTime> partTimes = tutor.getPartTime();
        List<TutorProject> projects = tutor.getProjects();
        List<Honor> honors = tutor.getHonor();
        List<Paper> papers = tutor.getPaper();
        for (PartTime partTime : partTimes) {
            num += tutorDao.addPartTime(partTime);
        }
        for (TutorProject tutorProject : projects) {
            num += tutorDao.addTutorProject(tutorProject);
        }
        for (Honor honor : honors) {
            num += tutorDao.addHonor(honor);
        }
        for (Paper paper : papers) {
            num += tutorDao.addPaper(paper);
        }
        num += tutorDao.addTutor(tutor);
        return num;
    }

}
