package com.cwk.springbootdata01.springbootdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TempContrl {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/department")
    public List<Map<String, Object>> departmentList(){
        return jdbcTemplate.queryForList("select * from department");
    }

}
