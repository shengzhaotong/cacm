package com.lab.controller;

import com.lab.pojo.FirstMenu;
import com.lab.pojo.SecondMenu;
import com.lab.service.MenuService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @Autowired
    JsonUtil jsonUtil;

    /**
     * 获取所有一级菜单
     * */
    @GetMapping("/get_all_first_menu")
    public String getAllFirstMenu () {
        return jsonUtil.getJson(menuService.selectAllFirstMenu());
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
