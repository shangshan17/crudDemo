package com.my.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.my.ssm.mapper.EmployeeMapper;
import com.my.ssm.pojo.Employee;
import com.my.ssm.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmployee(){
        return employeeMapper.getAllEmployee();
    }

    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum) {
        //开启分页功能
        PageHelper.startPage(pageNum,4);
        //查询所有员工信息
        List<Employee> list=employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> page=new PageInfo<>(list,5);

        return page;
    }

    @Override
    public void addEmployee(Employee employee){
        employeeMapper.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeMapper.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeMapper.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        log.info("访问到getEmployeeById");
        Employee employee=employeeMapper.getEmployeeById(id);
        return employee;
    }

}
