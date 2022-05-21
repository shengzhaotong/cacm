package com.lab.controller;

import com.lab.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {

    @Autowired
    FileUtil fileUtil;

//    @PostMapping("/file_upload")
//    public String fileUpload (@RequestParam("file") MultipartFile file) throws Exception{
//        String fileName = file.getOriginalFilename();
//        if("".equals(fileName) || fileName == null){
//            return "the file is null";
//        }
//        if(fileUtil.judgeFileSize(file)>5.0){
//            return "请上传5M以内的文件";
//        }
//
//        StringBuilder buffer = new StringBuilder();
//
//        buffer.append("/home/resume/");
//        buffer.append(fileName);
//        String path = new String(buffer);
//
//        return fileUtil.fileUpload(file, path);
//    }

}
