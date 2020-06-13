package com.baimahu.controller;

import com.baimahu.bean.Department;
import com.baimahu.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentMapper departmentMapper;
    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        return departmentMapper.selectDept(id);
    }
}
