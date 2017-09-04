package com.jee.control;

import com.jee.po.Salary;
import com.jee.service.impl.SalaryServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetSalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getSalary")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getSalary(HttpServletRequest request, String date) throws Exception {
        ModelAndView model=new ModelAndView();
        HttpSession session=request.getSession();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();
        Salary salary=new Salary();
        salary.setUser_id(user_id);
        salary.setDate(df.parse(date));
        Salary salary1=salaryService.getSalary(salary);
        model.addObject("salary",salary1);

        model.setViewName("employeesalary.jsp");
        return model;
    }

}
