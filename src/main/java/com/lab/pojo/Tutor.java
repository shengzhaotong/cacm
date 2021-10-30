package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    private int id;
    private String name;
    private String professionalDirection;
    private String researchDirection;
    private String address;
    private String postCode;
    private String tel;
    private String mail;
    private String introduce;
    private String post;
    private String image;
    private List<PartTime> partTime;
    private List<Honor> honor;
    private List<TutorProject> projects;
    private List<Paper> paper;

}
