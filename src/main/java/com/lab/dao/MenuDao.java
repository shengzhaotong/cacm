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
    List<SecondMenu> selectSecondMenuForList(List list);

    int addFirstMenu(FirstMenu firstMenu);
    int addSecondMenu(SecondMenu secondMenu);
    int addSecondMenuForList(List list);

    int updateFirstMenu(FirstMenu firstMenu);
    int updateSecondMenu(SecondMenu secondMenu);
    int updateSecondMenuForList(List list);

    int deleteFirstMenu(FirstMenu firstMenu);
    int deleteSecondMenu(SecondMenu secondMenu);
    int deleteSecondMenuForList(List list);

}
