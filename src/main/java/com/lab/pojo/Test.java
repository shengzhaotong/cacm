package com.lab.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {

    public MultipartFile multipartFile;
    public String birthday;
    public String email;
    public String grade;
    public String introduce;
    public String name;
    public String nation;
    public String position;
    public String professional;
    public String sex;
    public String viewPoint;

}
