package com.jee.control;

import com.jee.po.Educate;
import com.jee.po.Resume;
import com.jee.service.impl.EducateServiceImpl;
import com.jee.service.impl.EmployeeServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
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
public class InsertEducateController {
    @Autowired
    private EducateServiceImpl educateService;

    @RequestMapping("/insertEducate")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public String insertEducate(String educateName,String educateTime,String educateDepartment) throws Exception {
            Educate educate=new Educate();
            educate.setEducateName(educateName);
            educate.setEducateDepartment(educateDepartment);
            SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
            educate.setEducateTime(df.parse(educateTime));
            educateService.insertEducate(educate);
            return "redirect:/getEaducateList.action";
    }

}
