package com.lab.service;

import com.lab.dao.MenuDao;
import com.lab.dao.NamesDao;
import com.lab.pojo.FirstMenu;
import com.lab.pojo.Names;
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
    NamesDao namesDao;

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
        long textID = idWorker.nextId();
        firstMenu.setId(id);
        Names names = firstMenu.getNames();
        names.setId(textID);
        firstMenu.setTextId(textID);
        int num = 0;
        num += namesDao.insert(names);
        List<SecondMenu> secondMenus = firstMenu.getSecondMenus();
        if (secondMenus != null) {
            for (SecondMenu secondMenu : secondMenus) {
                long textId = idWorker.nextId();
                secondMenu.setFirstMenu(id);
                Names names1 = secondMenu.getNames();
                names1.setId(textId);
                secondMenu.setTextId(textId);
                num += namesDao.insert(names1);
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
            num += menuDao.updateSecondMenuForList(secondMenus);
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
            num += menuDao.updateSecondMenuForList(secondMenus);
        }
        num += menuDao.deleteFirstMenu(firstMenu);
        return num;
    }

    public int deleteSecondMenu (SecondMenu secondMenu) {
        return menuDao.deleteSecondMenu(secondMenu);
    }

}
