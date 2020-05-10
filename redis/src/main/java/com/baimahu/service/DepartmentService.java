package com.baimahu.service;

import com.baimahu.bean.Department;
import com.baimahu.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "dep", cacheManager = "departmentCacheManager")
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    @Cacheable(cacheNames = "dep")
    public Department getDept(Integer id) {
        System.out.println("------ get department -----");
        return departmentMapper.selectDept(id);
    }

    public void insertDept(Department department) {
        departmentMapper.insertDept(department);
    }
}
