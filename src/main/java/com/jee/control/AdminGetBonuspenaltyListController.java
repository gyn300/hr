package com.jee.control;

import com.jee.po.Attendance;
import com.jee.po.Bonuspenalty;
import com.jee.po.Employee;
import com.jee.po.Resume;
import com.jee.service.impl.BonuspenaltyServiceImpl;
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
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminGetBonuspenaltyListController {
    @Autowired
    private BonuspenaltyServiceImpl bonuspenaltyService;

    @RequestMapping("/adminGetBonuspenaltyList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView adminGetBonuspenaltyList(String sTime) throws Exception {

        ModelAndView model=new ModelAndView();

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        List<Bonuspenalty> bonuspenalties=bonuspenaltyService.getAllBonuspenaltyList();

        List<Bonuspenalty> sBonuspenaltys=new ArrayList<Bonuspenalty>();
        for (Bonuspenalty bonuspenalty:bonuspenalties
                ) {
            if(df.format(bonuspenalty.getTime()).contains(sTime)){
                sBonuspenaltys.add(bonuspenalty);
            }

        }
        if(sBonuspenaltys!=null) {
            model.addObject("sBonuspenaltys", sBonuspenaltys);
        }
        model.setViewName("adminbonuspenaltylist.jsp");
        return model;
    }

}
