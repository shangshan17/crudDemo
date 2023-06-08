package com.my.ssm.service;

import com.github.pagehelper.PageInfo;
import com.my.ssm.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    PageInfo<Employee> getEmployeePage(Integer pageNum);

    void addEmployee(Employee employee);

    void deleteEmployee(Integer id);

    void updateEmployee(Employee employee);

    //根据id查询员工信息
    Employee getEmployeeById(Integer id);
}
