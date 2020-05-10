package com.baimahu;

import com.baimahu.bean.Department;
import com.baimahu.bean.Employee;
import com.baimahu.mapper.EmployeeMapper;
import com.baimahu.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Redis常见的五大数据类型
 *  String（字符串）、List（列表）、Set（集合）、Hash（散列）、ZSet（有序集合）
 *  stringRedisTemplate.opsForValue()[String（字符串）]
 *  stringRedisTemplate.opsForList()[List（列表）]
 *  stringRedisTemplate.opsForSet()[Set（集合）]
 *  stringRedisTemplate.opsForHash()[Hash（散列）]
 *  stringRedisTemplate.opsForZSet()[ZSet（有序集合）]
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTest {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    DepartmentService departmentService;

    @Autowired
    RedisTemplate<Object, Employee> employeeRedisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis() {
        stringRedisTemplate.opsForValue().append("kk", "vv");
        String res = stringRedisTemplate.opsForValue().get("kk");
        System.out.println(res);

        Employee emp = employeeMapper.getEmployeeById(1);
        employeeRedisTemplate.opsForValue().set("emp1", emp);
        Employee empRes = employeeRedisTemplate.opsForValue().get("emp1");
        System.out.println(empRes);
    }

    @Test
    public void testMybatis() {
        //Employee employee = new Employee(1, "Horatio", "333@qq.com", 0, 100);
        //employeeMapper.insertEmployee(employee);
        Employee emp = employeeMapper.getEmployeeById(1);
        System.out.println(emp);

//        employee.setLastName("Alexander");
//        employeeMapper.updateEmployee(employee);
//        emp = employeeMapper.getEmployeeById(1);
//        System.out.println(emp);
//
//        employeeMapper.deleteEmployee(1);
    }

    @Test
    public void testDept() {
        //Department department = new Department(1,"cloud");
        //departmentService.insertDept(department);
        Department dep = departmentService.getDept(1);
        System.out.println(dep);
    }
}
