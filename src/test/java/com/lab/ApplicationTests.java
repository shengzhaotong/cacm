package com.lab;

import com.lab.dao.MenuDao;
import com.lab.pojo.FirstMenu;
import com.lab.pojo.SecondMenu;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class ApplicationTests {

    @Autowired
    MenuDao menuDao;

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    void contextLoads() {
        ArrayList<FirstMenu> objects = new ArrayList<>();
        objects.add(new FirstMenu(1,"df",null));
        objects.add(new FirstMenu(3,"df",null));
        objects.add(new FirstMenu(4,"df",null));
        objects.add(new FirstMenu(8,"df",null));
        List<SecondMenu> secondMenus = menuDao.selectSecondMenuForList(objects);
        secondMenus.forEach(System.out::println);
    }

}
