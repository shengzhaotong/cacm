package com.lab.dao;

import com.lab.pojo.FirstMenu;
import com.lab.pojo.SecondMenu;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MenuDao {

    List<FirstMenu> selectAllFirstMenu();
    List<SecondMenu> selectSecondMenu(long firstMenu);

    int addFirstMenu(FirstMenu firstMenu);
    int addSecondMenu(SecondMenu secondMenu);

    int updateFirstMenu(FirstMenu firstMenu);
    int updateSecondMenu(SecondMenu secondMenu);

    int deleteFirstMenu(FirstMenu firstMenu);
    int deleteSecondMenu(SecondMenu secondMenu);

}
