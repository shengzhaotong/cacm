package com.lab.dao;

import com.lab.pojo.Teacher;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TeacherDao {

    List<Teacher> selectAllTeacher();
    int addTeacher(Teacher teacher);
    int updateTeacher(Teacher teacher);
    int deleteTeacher(Teacher teacher);

}
