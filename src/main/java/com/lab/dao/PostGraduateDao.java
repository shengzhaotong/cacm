package com.lab.dao;

import com.lab.pojo.PostGraduate;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PostGraduateDao {

    List<PostGraduate> selectAllPostGraduate();
    int insertPostGraduate(PostGraduate postGraduate);
    int updatePostGraduate(PostGraduate postGraduate);
    int deletePostGraduate(PostGraduate postGraduate);

}
