package com.jee.control;

import com.jee.po.Bonuspenalty;
import com.jee.service.impl.BonuspenaltyServiceImpl;
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
public class EmployeeGetBonuspenaltyListController {
    @Autowired
    private BonuspenaltyServiceImpl bonuspenaltyService;
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/employeeGetBonuspenaltyList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView employeeGetBonuspenaltyList(HttpServletRequest request, String sTime) throws Exception {
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();
        ModelAndView model=new ModelAndView();

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        List<Bonuspenalty> bonuspenalties=bonuspenaltyService.getBonuspenaltyList(user_id);

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
        model.setViewName("employeebonuspenaltylist.jsp");
        return model;
    }

}
