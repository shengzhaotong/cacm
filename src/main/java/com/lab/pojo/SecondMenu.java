package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondMenu {

    private int id;
    private String name;
    private String link;
    private String firstMenu;

}
