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

    public Double judgeFileSize(MultipartFile file) throws Exception{
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
        return -1.0;
    }

    public String fileUpload(MultipartFile file, String path) throws IOException{
        File file1 = new File(path);
        InputStream inputStream = file.getInputStream();
        OutputStream outputStream = new FileOutputStream(file1);
        int len;
        byte[] buffer = new byte[1024];
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        logger.info("上传了文件："+path);
        return "success";
    }

    public String fileUpload(CommonsMultipartFile file, HttpServletRequest request) throws IOException{
        return this.fileUpload(file,request.getServletContext().getRealPath("/")+jsonUtil.getJson(new Date()));
    }

}
