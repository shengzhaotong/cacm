package com.lab.controller;

import com.lab.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
public class Upload {

    @Autowired
    FileUtil fileUtil;

    @PostMapping("/signup")
    public String upload(@RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        if("".equals(fileName) || fileName == null){
            return "未选择文件";
        }
        StringBuffer buffer = new StringBuffer();

        buffer.append("/home/answer/");
        buffer.append(fileName);
        String path = new String(buffer);

        return fileUtil.fileUpload(file, path);

    }

}
