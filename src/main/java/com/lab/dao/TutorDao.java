package com.lab.dao;

import com.lab.pojo.*;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface TutorDao {

    List<Tutor> selectAllTutor();
    int addTutor(Tutor tutor);
    int updateTutor(Tutor tutor);
    int deleteTutor(Tutor tutor);

    List<PartTime> selectPartTime(String tutor);
    int addPartTime(PartTime partTime);
    int updatePartTime(PartTime partTime);
    int deletePartTime(PartTime partTime);

    List<Honor> selectHonor(String tutor);
    int addHonor(Honor honor);
    int updateHonor(Honor honor);
    int deleteHonor(Honor honor);

    List<TutorProject> selectTutorProjects(String tutor);
    int addTutorProject(TutorProject tutorProject);
    int updateTutorProject(TutorProject tutorProject);
    int deleteTutorProject(TutorProject tutorProject);

    List<Paper> selectPaper(String tutor);
    int addPaper(Paper paper);
    int updatePaper(Paper paper);
    int deletePaper(Paper paper);

}
