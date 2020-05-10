package com.baimahu.service;

import com.baimahu.bean.Employee;
import com.baimahu.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "emp", cacheManager = "employeeCacheManager")
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    @Cacheable(cacheNames = {"emp"}, condition = "#id>0")
    public Employee getEmp(Integer id) {
        System.out.println("------- search employee -------" + id);
        return employeeMapper.getEmployeeById(id);
    }
}
