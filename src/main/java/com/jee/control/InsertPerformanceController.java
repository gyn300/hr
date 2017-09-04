package com.jee.control;

import com.jee.mapper.UserMapper;
import com.jee.po.Employee;
import com.jee.po.Performance;
import com.jee.po.Resume;
import com.jee.service.impl.EmployeeServiceImpl;
import com.jee.service.impl.PerformanceServiceImpl;
import com.jee.service.impl.PositionServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InsertPerformanceController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private PerformanceServiceImpl performanceService;
    @RequestMapping("/insertPerformance")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView insertPerformance(int user_id,double money ) throws Exception {

        ModelAndView model=new ModelAndView();
        Employee employee=employeeService.getEmployee(user_id);
        Performance performance=new Performance();
        performance.setUser_id(user_id);
        performance.setName(employee.getName());
        performance.setPosition(employee.getPosition());
        performance.setMoney(money);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
        performance.setDate(df.parse(df.format(new Date())));

        List<Performance> performances=performanceService.getPerformanceList(user_id);
        //判断该月份是否已经添加绩效 true表示已经添加
        boolean flag=false;
        for (Performance performance1:performances
             ) {
            if(df.format(performance1.getDate()).equals(performance.getDate())){
                flag=true;
            }
        }
        if(!flag){
            if(performanceService.insertPerformance(performance)!=0){
                model.addObject("data","添加成功");
            }else {
                model.addObject("data","添加失败");
            }
        }else {
            model.addObject("data","添加失败,原因:已添加");
        }
        model.setViewName("addperformance.jsp");
        return model;
     }


}
