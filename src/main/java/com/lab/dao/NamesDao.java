package com.lab.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lab.pojo.Names;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface NamesDao extends BaseMapper<Names> {

    String selectEnByID(long id);
    String selectZhByID(long id);

}
