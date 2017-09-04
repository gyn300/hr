package com.jee.control;

import com.jee.po.Bonuspenalty;
import com.jee.po.Department;
import com.jee.po.Educate;
import com.jee.po.Performance;
import com.jee.service.impl.BonuspenaltyServiceImpl;
import com.jee.service.impl.DepartmentServiceImpl;
import com.jee.service.impl.EducateServiceImpl;
import com.jee.service.impl.PerformanceServiceImpl;
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
public class GetSalaryAttributeController {
    @Autowired
    private PerformanceServiceImpl performanceService;
    @Autowired
    private BonuspenaltyServiceImpl bonuspenaltyService;
    @RequestMapping("/getSalaryAtt")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getSalaryAtt(int user_id,String date) throws Exception {
        ModelAndView model=new ModelAndView();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        List<Performance> performances=performanceService.getPerformanceList(user_id);
        Performance performance1=null;
        for (Performance performance:performances
             ) {
            if(df.format(performance.getDate()).contains(date)){
                performance1=performance;
            }
        }
        if(performance1!=null){
            model.addObject("performance1",performance1);
        }
        double bonuspenaltyMoney=0;
        List<Bonuspenalty> bonuspenalties=bonuspenaltyService.getBonuspenaltyList(user_id);
        List<Bonuspenalty> bonuspenalties1=new ArrayList<Bonuspenalty>();
        for (Bonuspenalty bonuspenaltie:bonuspenalties
             ) {
            if(df.format(bonuspenaltie.getTime()).contains(date)){
                bonuspenaltyMoney+=bonuspenaltie.getMoney();
            }
        }
        model.addObject("user_id",user_id);
        model.addObject("bonuspenaltyMoney",bonuspenaltyMoney);
        model.setViewName("adminaddsalary.jsp");
        return model;
    }

}
