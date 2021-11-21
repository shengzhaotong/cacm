package com.lab.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lab.dao.ListDao;
import com.lab.pojo.Enums;
import com.lab.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListController {

    @Autowired
    JsonUtil jsonUtil;

    @Autowired
    ListDao listDao;

    @GetMapping("/get_all_list")
    public String getAllList () throws JsonProcessingException {
        return jsonUtil.getJson(listDao.selectList(null));
    }

    @PostMapping("/add_list")
    public int addList (@RequestBody Enums enums) {
        return listDao.insert(enums);
    }

    @PostMapping("/update_list")
    public int updateList (@RequestBody Enums enums) {
        return listDao.updateById(enums);
    }

    @PostMapping("/delete_list")
    public int deleteList (@RequestBody Enums enums) {
        return listDao.deleteById(enums.getId());
    }

}
