package com.lab;

import com.lab.dao.ExperienceDao;
import com.lab.pojo.*;
import com.lab.service.TutorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BackApplicationTests {

    @Autowired
    TutorService tutorService;

    @Autowired
    ExperienceDao experienceDao;

//    private int id;
//    private String name;
//    private String professionalDirection;
//    private String researchDirection;
//    private String address;
//    private String postCode;
//    private String tel;
//    private String mail;
//    private String introduce;
//    private String post;
//    private List<PartTime> partTime;
//    private List<Honor> honor;
//    private List<TutorProject> projects;
//    private List<Paper> paper;

    @Test
    void contextLoads() {
        List<Experience> sdaf = experienceDao.selectExperience("ifdg", true);
        for (Experience experience : sdaf) {
            System.out.println(experience);
        }
    }
}
