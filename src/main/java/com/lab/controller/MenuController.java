package com.lab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.Exception.RequestParameterException;
import com.lab.dao.NamesDao;
import com.lab.pojo.FirstMenu;
import com.lab.pojo.SecondMenu;
import com.lab.service.MenuService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    NamesDao namesDao;

    @Autowired
    MenuService menuService;

    @Autowired
    JsonUtil jsonUtil;

    /**
     * 获取所有一级菜单
     * */
    @GetMapping("/get_all_first_menu")
    public String getAllFirstMenu (@RequestParam String language) throws JsonProcessingException {

        List<FirstMenu> firstMenus = menuService.selectAllFirstMenu();

        if (firstMenus != null) {
            if ("zh".equals(language)) {
                for (FirstMenu firstMenu : firstMenus) {
                    String name = namesDao.selectZhByID(firstMenu.getTextId());
                    firstMenu.setText(name);
                    List<SecondMenu> secondMenus = firstMenu.getSecondMenus();
                    if (secondMenus != null) {
                        for (SecondMenu secondMenu : secondMenus) {
                            String text = namesDao.selectZhByID(secondMenu.getTextId());
                            secondMenu.setText(text);
                        }
                    }
                }
            } else if ("en".equals(language)) {
                for (FirstMenu firstMenu : firstMenus) {
                    System.out.println(firstMenu.getTextId());
                    String name = namesDao.selectEnByID(firstMenu.getTextId());
                    firstMenu.setText(name);
                    List<SecondMenu> secondMenus = firstMenu.getSecondMenus();
                    if (secondMenus != null) {
                        for (SecondMenu secondMenu : secondMenus) {
                            String text = namesDao.selectEnByID(secondMenu.getTextId());
                            secondMenu.setText(text);
                        }
                    }
                }
            } else {
                throw new RequestParameterException("请求参数格式不正确");
            }
        }

        return jsonUtil.getJson(firstMenus);
    }

    /**
     * 增加一级菜单
     * */
    @PostMapping("/add_first_menu")
    public int addFirstMenu (@RequestBody FirstMenu firstMenu) {
        return menuService.addFirstMenu(firstMenu);
    }

    /**
     * 增加二级菜单
     * */
    @PostMapping("/add_second_menu")
    public int addSecondMenu (@RequestBody SecondMenu secondMenu) {
        return menuService.addSecondMenu(secondMenu);
    }

    /**
     * 更改一级菜单
     * */
    @PostMapping("/update_first_menu")
    public int updateFirstMenu (@RequestBody FirstMenu firstMenu) {
        return menuService.updateFirstMenu(firstMenu);
    }

    /**
     * 更改二级菜单
     * */
    @PostMapping("/update_second_menu")
    public int updateSecondMenu (@RequestBody SecondMenu secondMenu) {
        return menuService.updateSecondMenu(secondMenu);
    }

    /**
     * 删除一级菜单
     * */
    @PostMapping("/delete_first_menu")
    public int deleteFirstMenu (@RequestBody FirstMenu firstMenu) {
        return menuService.deleteFirstMenu(firstMenu);
    }

    /**
     * 删除二级菜单
     * */
    @PostMapping("/delete_second_menu")
    public int deleteSecondMenu (@RequestBody SecondMenu secondMenu) {
        return menuService.deleteSecondMenu(secondMenu);
    }

}
