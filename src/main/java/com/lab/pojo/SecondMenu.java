package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SecondMenu {

    private int id;
    private String link;
    private long textId;
    private String text;
    private Names names;
    private long firstMenu;

}
