package com.lab;

import com.lab.dao.TutorDao;
import com.lab.pojo.Tutor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class BackApplicationTests {

    @Autowired
    TutorDao tutorDao;

    @Test
    void contextLoads() {
        List<Tutor> tutors = tutorDao.selectAllTutor();
        System.out.println(tutors.get(0));
    }
}
