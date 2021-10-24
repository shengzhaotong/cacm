package com.lab.service;

import com.lab.dao.AchievementsDao;
import com.lab.pojo.Achievement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementsService {

    @Autowired
    AchievementsDao achievementsDao;

    public List<Achievement> selectAllAchievements () {
        return achievementsDao.selectAllAchievements();
    }

    public int addAchievement (Achievement achievement) {
        return achievementsDao.addAchievement(achievement);
    }

    public int deleteAchievement (Achievement achievement) {
        return achievementsDao.deleteAchievement(achievement);
    }

}
