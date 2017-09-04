package com.jee.control;

import com.jee.po.Employee;
import com.jee.service.impl.EmployeeServiceImpl;
import com.jee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DirectorGetEmployeeListController {
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getDirectorEmployeeList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getDirectorEmployeeList(HttpServletRequest request) throws Exception {
        ModelAndView model=new ModelAndView();
        List<Employee> employees=employeeService.getEmployeeList();
        List<Employee> employees1=new ArrayList<Employee>();
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();
        String department=employeeService.getEmployee(user_id).getDepartment();
        for (Employee employee:employees
             ) {
            //不为null 表示离职
            if(employee.getLeaveTime()!=null){
                employees1.add(employee);
            }
            if(!(employee.getDepartment().equals(department))){
                employees1.add(employee);
            }
        }
        employees.removeAll(employees1);
        model.addObject("employees",employees);
        model.setViewName("directorperformance.jsp");
        return model;
    }


}
