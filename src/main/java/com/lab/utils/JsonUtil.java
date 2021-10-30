package com.lab.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


@Component
public class JsonUtil {

    public String getJson(Object object){

        return this.getJson(object,"yyyy-MM-dd HH:mm:ss");

    }

    public String getJson(Object object,String dateFormat){

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        objectMapper.setDateFormat(simpleDateFormat);

        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

}
