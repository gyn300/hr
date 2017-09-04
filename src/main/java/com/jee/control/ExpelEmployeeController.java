package com.jee.control;

import com.jee.po.Employee;
import com.jee.po.Resume;
import com.jee.service.impl.EmployeeServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
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
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ExpelEmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/expel")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView expel(int user_id) throws Exception {
            ModelAndView model=new ModelAndView();
            Employee employee=employeeService.getEmployee(user_id);
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");

            employee.setLeaveTime(df.parse(df.format(new Date())));
            if(employeeService.updateEmployee(employee)!=0){
                model.addObject("data","开除成功");
            }else {
                model.addObject("data","开除失败");
            }
            model.setViewName("onjobemployeeadmin.jsp");
            return model;
        }


}
