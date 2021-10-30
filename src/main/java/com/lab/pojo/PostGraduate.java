package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostGraduate {

    private int id;
    private String name;
    private String degree;
    private String researchDirection;
    private String image;
    private String isGraduate;
    private List<Experience> experiences;

}
