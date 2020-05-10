package com.baimahu.mapper;

import com.baimahu.bean.Department;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DepartmentMapper {
    @Select("select * from department where id = #{id}")
    Department selectDept(Integer id);

    @Insert("insert into department(departmentName) values(#{departmentName})")
    void insertDept(Department department);
}
