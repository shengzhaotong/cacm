package com.lab.controller;

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

    @GetMapping("/get_achievement")
    public String getAchievement () {
        return jsonUtil.getJson(achievementsService.selectAllAchievements());
    }

    @PostMapping("/add_achievement")
    public int addAchievement (@RequestBody Achievement achievement) {
        return achievementsService.addAchievement(achievement);
    }

    @PostMapping("/delete_achievement")
    public int deleteAchievement (@RequestBody Achievement achievement) {
        return achievementsService.deleteAchievement(achievement);
    }

}
