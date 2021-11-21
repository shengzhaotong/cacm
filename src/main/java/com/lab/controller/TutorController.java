package com.lab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.service.TutorService;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    TutorService tutorService;

    @GetMapping("/get_all_tutor")
    public String getAllTutor () throws JsonProcessingException {
        return jsonUtil.getJson(tutorService.selectAllTutor());
    }

}
