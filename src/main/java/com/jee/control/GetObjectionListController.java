package com.jee.control;

import com.jee.po.Objection;
import com.jee.po.Salary;
import com.jee.service.impl.ObjectionServiceImpl;
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
import java.util.List;

@Controller
public class GetObjectionListController {
    @Autowired
    private ObjectionServiceImpl objectionService;


    @RequestMapping("/getObjectionList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getSalary() throws Exception {
        ModelAndView model=new ModelAndView();
        List<Objection> objections=objectionService.getAllObjectionList();
        model.addObject("objections",objections);
        model.setViewName("adminobjectionlist.jsp");
        return model;
    }

}
