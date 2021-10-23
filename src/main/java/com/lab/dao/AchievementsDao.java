package com.lab.dao;

import com.lab.pojo.Achievement;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AchievementsDao {

    List<Achievement> selectAllAchievements();

}
