package com.jee.control;

import com.jee.po.Employee;
import com.jee.service.impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GetEmployeeListController {
    @Autowired
    private EmployeeServiceImpl employeeService;


    @RequestMapping("/getOnJobEmployeeList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getOnJobEmployeeList() throws Exception {
        ModelAndView model=new ModelAndView();
        List<Employee> employees=employeeService.getEmployeeList();
        List<Employee> employees1=new ArrayList<Employee>();
        for (Employee employee:employees
             ) {
            //不为null 表示离职
            if(employee.getLeaveTime()!=null){
                employees1.add(employee);
            }
        }
        employees.removeAll(employees1);
        model.addObject("employees",employees);
        model.setViewName("/onjobemployeeadmin.jsp");
        return model;
    }

    @RequestMapping("/getLeaveJobEmployeeList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getLeaveJobEmployeeList() throws Exception {
        ModelAndView model=new ModelAndView();
        List<Employee> employees=employeeService.getEmployeeList();
        List<Employee> employees1=new ArrayList<Employee>();
        for (Employee employee:employees
                ) {
            if(employee.getLeaveTime()==null){
                employees1.add(employee);
            }
        }
        employees.removeAll(employees1);
        model.addObject("employees",employees);
        model.setViewName("/leavejobemployeeadmin.jsp");
        return model;
    }
}
