package com.jee.control;

import com.jee.po.Bonuspenalty;
import com.jee.po.Educate;
import com.jee.po.Employee;
import com.jee.po.Resume;
import com.jee.service.impl.BonuspenaltyServiceImpl;
import com.jee.service.impl.EducateServiceImpl;
import com.jee.service.impl.EmployeeServiceImpl;
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

@Controller
public class InsertBonuspenaltyController {
    @Autowired
    private BonuspenaltyServiceImpl bonuspenaltyService;
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @RequestMapping("/insertBonuspenalty")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView insertBonuspenalty(int user_id,String name,String explains,double money,String time) throws Exception {
        Resume resume= new Resume();
        ModelAndView model=new ModelAndView();
        Bonuspenalty bonuspenalty=new Bonuspenalty();
        bonuspenalty.setUser_id(user_id);
        bonuspenalty.setName(name);
        bonuspenalty.setExplains(explains);
        bonuspenalty.setMoney(money);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        bonuspenalty.setTime(df.parse(time));
        if(bonuspenaltyService.insertBonuspenalty(bonuspenalty)!=0){
            model.addObject("data","添加成功");
        }else {
            model.addObject("data","添加失败");
        }
        Employee employee=employeeService.getEmployee(user_id);
        resume=resumeService.getResume(user_id);
        model.addObject("resume", resume);
        model.addObject("employee",employee);
        model.setViewName("employeeBonuspenalty.jsp");
        return model;
    }

}
