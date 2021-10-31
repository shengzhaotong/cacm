package com.lab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.pojo.Achievement;
import com.lab.service.AchievementsService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AchievementsController {

    @Autowired
    AchievementsService achievementsService;

    @Autowired
    JsonUtil jsonUtil;

    /**
     * 获取所有研究成果
     * */
    @GetMapping("/get_achievement")
    public String getAchievement () throws JsonProcessingException {
        return jsonUtil.getJson(achievementsService.selectAllAchievements());
    }

    /**
     * 增加研究成果
     * */
    @PostMapping("/add_achievement")
    public int addAchievement (@RequestBody Achievement achievement) {
        return achievementsService.addAchievement(achievement);
    }

    /**
     * 删除研究成果
     * */
    @PostMapping("/delete_achievement")
    public int deleteAchievement (@RequestBody Achievement achievement) {
        return achievementsService.deleteAchievement(achievement);
    }

}
