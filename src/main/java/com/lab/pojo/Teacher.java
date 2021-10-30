package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private int id;
    private String name;
    private String post;
    private String mail;
    private String address;
    private String postCode;
    private String tel;
    private String researchDirection;
    private String image;
    private List<Experience> experiences;
    private List<TutorProject> projects;
    private List<Paper> papers;

}
