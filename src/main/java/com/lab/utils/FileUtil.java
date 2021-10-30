package com.lab.utils;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.DecimalFormat;
import java.util.Date;

@Component
public class FileUtil {

    @Autowired
    JsonUtil jsonUtil;

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Double judgeFileSize(MultipartFile file) {
        try {
            CommonsMultipartFile cf = (CommonsMultipartFile) file;
            DiskFileItem fi = (DiskFileItem) cf.getFileItem();
            File f = fi.getStoreLocation();

            if (f.exists() && f.isFile()) {
                long fileS = f.length();
                DecimalFormat df = new DecimalFormat("#.00");
                if (fileS < 1073741824) {
                    String size = df.format((double) fileS / 1048576);
                    if (size != null) {
                        return Double.parseDouble(size.trim());//文件大小
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return -1.0;
    }

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

    public String fileUpload(CommonsMultipartFile file, HttpServletRequest request){
        return this.fileUpload(file,request.getServletContext().getRealPath("/")+jsonUtil.getJson(new Date()));
    }

}
