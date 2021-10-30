package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstMenu {

    private int id;
    private String name;
    private String link;
    private List<SecondMenu> secondMenus;

}
