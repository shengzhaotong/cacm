package com.lab.service;

import com.lab.dao.MenuDao;
import com.lab.pojo.FirstMenu;
import com.lab.pojo.SecondMenu;
import com.lab.utils.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    SnowflakeIdWorker idWorker;

    @Autowired
    MenuDao menuDao;

    public List<FirstMenu> selectAllFirstMenu () {
        List<FirstMenu> firstMenus = menuDao.selectAllFirstMenu();
        if (firstMenus != null) {
            for (FirstMenu firstMenu : firstMenus) {
                firstMenu.setSecondMenus(menuDao.selectSecondMenu(firstMenu.getId()));
            }
        }
        return firstMenus;
    }

    public List<SecondMenu> selectSecondMenu (long firstMenu) {
        return menuDao.selectSecondMenu(firstMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int addFirstMenu (FirstMenu firstMenu) {
        long id = idWorker.nextId();
        firstMenu.setId(id);
        int num = 0;
        List<SecondMenu> secondMenus = firstMenu.getSecondMenus();
        if (secondMenus != null) {
            for (SecondMenu secondMenu : secondMenus) {
                secondMenu.setFirstMenu(id);
                num += menuDao.addSecondMenu(secondMenu);
            }
        }
        num += menuDao.addFirstMenu(firstMenu);
        return num;
    }

    public int addSecondMenu (SecondMenu secondMenu) {
        return menuDao.addSecondMenu(secondMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int updateFirstMenu (FirstMenu firstMenu) {
        int num = 0;
        List<SecondMenu> secondMenus = firstMenu.getSecondMenus();
        if (secondMenus != null) {
            for (SecondMenu secondMenu : secondMenus) {
                num += menuDao.updateSecondMenu(secondMenu);
            }
        }
        num += menuDao.updateFirstMenu(firstMenu);
        return num;
    }

    public int updateSecondMenu (SecondMenu secondMenu) {
        return menuDao.updateSecondMenu(secondMenu);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout=36000,rollbackFor=Exception.class)
    public int deleteFirstMenu (FirstMenu firstMenu) {
        int num = 0;
        List<SecondMenu> secondMenus = firstMenu.getSecondMenus();
        if (secondMenus != null) {
            for (SecondMenu secondMenu : secondMenus) {
                num += menuDao.deleteSecondMenu(secondMenu);
            }
        }
        num += menuDao.deleteFirstMenu(firstMenu);
        return num;
    }

    public int deleteSecondMenu (SecondMenu secondMenu) {
        return menuDao.deleteSecondMenu(secondMenu);
    }

}
