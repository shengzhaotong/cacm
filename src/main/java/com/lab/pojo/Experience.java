package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Experience {

    private int id;
    private String value;
    private String belongTo;
    private boolean isTeacher;

}
