package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstMenu {

    private long id;
    private String link;
    private long textId;
    private String text;
    private Names names;
    private List<SecondMenu> secondMenus;

}
