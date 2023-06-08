package com.my.ssm.controller;

import ch.qos.logback.classic.Logger;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.github.pagehelper.PageInfo;
import com.my.ssm.pojo.Employee;
import com.my.ssm.service.EmployeeService;
import com.my.ssm.service.impl.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@Slf4j
public class EmployeeController {

    /*
    * 查询所有的员工信息：/employee-->get
    * 查询员工分页信息:/employee/page-->get
    * 根据id查询员工信息:/employee/1-->get
    * 跳转到添加页面：/to/add-->get
    * 添加员工信息：/employee-->post
    * 修改员工信息:/employee-->put
    * 删除员工信息：/employee/1-->delete
    * */
    @Autowired
    EmployeeService employeeService;


    //查询所有员工信息
    @RequestMapping(value = "/employee" ,method = RequestMethod.GET)
    public String getAllEmployee(Model model){
        List<Employee> list=employeeService.getAllEmployee();
        model.addAttribute("mylist",list);

        return "employee_list";
    }

    //分页查询员工信息
    @RequestMapping(value = "/employee/page/{pageNum}",method = RequestMethod.GET)
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,Model model){
        //获取员工分页信息
        PageInfo<Employee> page= employeeService.getEmployeePage(pageNum);
        //将分页数据共享到请求域中
        model.addAttribute("page",page);
        return "employee_list";
    }

    //跳转到添加页面
    @RequestMapping(value = "/to/add",method = RequestMethod.GET)
    public String toAdd(){
        return "employee_add";
    }

    //添加员工信息(添加一条)
    @RequestMapping(value = "/employee/add",method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        log.info("进入添加controller");
        log.info(String.valueOf(employee));
        employeeService.addEmployee(employee);
        return "redirect:/employee/page/1";
    }

    //添加员工信息(批量添加)


    //删除员工信息
    @RequestMapping(value = "/employee/delete/{id}",method = RequestMethod.DELETE)
    public String deleteEmployee(@PathVariable("id") Integer id){
        log.info("进入了删除controller");
        employeeService.deleteEmployee(id);
        return "redirect:/employee/page/1";
    }

    @RequestMapping(value = "/to/update/{id}",method = RequestMethod.GET)
    public String toUpdate(@PathVariable("id") Integer id, Model model){
        Employee employee=employeeService.getEmployeeById(id);
        log.info("查询到该员工:"+String.valueOf(employee));
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    //更改员工信息
    @RequestMapping(value = "/employee/update",method = RequestMethod.PUT)
    public String updateEmployee(Employee employee){
        employeeService.updateEmployee(employee);
        return "redirect:/employee/page/1";
    }

}
