package com.baimahu.mapper;

import com.baimahu.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee where id = #{id}")
    Employee getEmployeeById(Integer id);

    @Insert("insert into employee(lastName,email,gender,d_id) values(#{lastName},#{email},#{gender},#{dId})")
    void insertEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    void deleteEmployee(Integer id);

    @Update("update employee set lastName = #{lastName}, email = #{email}, gender = #{gender}, d_id = #{dId} where id = #{id}")
    void updateEmployee(Employee employee);
}
