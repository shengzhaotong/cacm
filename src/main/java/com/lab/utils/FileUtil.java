package com.lab.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Component
public class FileUtil {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public String fileUpload(MultipartFile file, String path){
        File file1 = new File(path);
        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int len;
        byte[] buffer = new byte[1024];
        while (true){
            try {
                if (inputStream != null){
                    if ((len = inputStream.read(buffer)) == -1) break;
                } else {
                    throw new RuntimeException("未获取到文件输入流");
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            try {
                if (outputStream != null) {
                    outputStream.write(buffer,0,len);
                } else {
                    throw new RuntimeException("未获取到文件输出流");
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
            try {
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(outputStream!=null){
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("上传了文件："+path);
        return "success";
    }

}
