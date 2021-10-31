package com.lab.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class JsonUtil {

    public String getJson(Object object) throws JsonProcessingException{
        return this.getJson(object,"yyyy-MM-dd HH:mm:ss");
    }

    public String getJson(Object object,String dateFormat)throws JsonProcessingException{
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        objectMapper.setDateFormat(simpleDateFormat);
        return objectMapper.writeValueAsString(object);
    }

}
