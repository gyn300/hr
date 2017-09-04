package com.jee.control;

import com.jee.po.Bonuspenalty;
import com.jee.po.Performance;
import com.jee.po.Salary;
import com.jee.service.impl.BonuspenaltyServiceImpl;
import com.jee.service.impl.PerformanceServiceImpl;
import com.jee.service.impl.SalaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetSalaryListController {
    @Autowired
    private SalaryServiceImpl salaryService;

    @RequestMapping("/getSalaryList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getSalaryList(String date) throws Exception {
        ModelAndView model=new ModelAndView();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        List<Salary> salaries=salaryService.getSalaryList();
        List<Salary> salaries1=new ArrayList<Salary>();
        for (Salary salary:salaries
             ) {
            if(df.format(salary.getDate()).contains(date)){
                salaries1.add(salary);
            }
        }
        if(salaries1!=null){
            model.addObject("salaries1",salaries1);
        }

        model.setViewName("adminsalarylist.jsp");
        return model;
    }

}
