package com.jee.control;

import com.jee.po.Resume;
import com.jee.po.Salary;
import com.jee.service.impl.ResumeServiceImpl;
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
import java.util.Date;

@Controller
public class InsertSalaryController {
    @Autowired
    private SalaryServiceImpl salaryService;

    @RequestMapping("/insertSalary")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView insertSalary(Salary salary) throws Exception {
            ModelAndView model=new ModelAndView();
            double totalSalary=salary.getBaseSalary()+salary.getPerformanceSalary()+salary.getOvertimeSalary()+salary.getBonuspenaltySalary()+salary.getSocialSecurity();
            salary.setTotalSalary(totalSalary);
            if(salaryService.insertSalary(salary)!=0){
                model.addObject("data","添加成功");
            }else {
                model.addObject("data","添加失败");
            }
            model.setViewName("adminaddsalary.jsp");
            return model;
        }


}
