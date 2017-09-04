package com.jee.control;

import com.jee.mapper.EmployeeMapper;
import com.jee.po.Employee;
import com.jee.po.Resume;
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
public class EmployeeDetailController {
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/employeeDetail")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView employeeDetail(HttpServletRequest request) throws Exception {
        Resume resume= new Resume();
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");


        ModelAndView model=new ModelAndView();
         int user_id=userService.getUser(user_name).getId();
         Employee employee=employeeService.getEmployee(user_id);
            resume=resumeService.getResume(user_id);

            model.addObject("resume", resume);
            model.addObject("employee",employee);
            model.setViewName("employeedetail.jsp");
            return model;
        }


}
