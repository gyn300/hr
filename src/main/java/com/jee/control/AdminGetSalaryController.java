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

@Controller
public class AdminGetSalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/adminGetSalary")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView adminGetSalary(int user_id, String date) throws Exception {
        ModelAndView model=new ModelAndView();

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");


        Salary salary=new Salary();
        salary.setUser_id(user_id);
        salary.setDate(df.parse(date));
        Salary salary1=salaryService.getSalary(salary);
        model.addObject("salary",salary1);

        model.setViewName("adminobjectionsalarydetail.jsp");
        return model;
    }

}
