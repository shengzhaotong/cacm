package com.lab.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lab.pojo.Enums;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ListDao extends BaseMapper<Enums> {
}
