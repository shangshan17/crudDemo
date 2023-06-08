package com.my.ssm.mapper;

import com.my.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface EmployeeMapper {

    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    void deleteEmployee(Integer id);

    void updateEmployee(Employee employee);

    Employee getEmployeeById(Integer id);
}
