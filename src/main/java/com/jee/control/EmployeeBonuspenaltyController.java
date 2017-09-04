package com.jee.control;

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

@Controller
public class EmployeeBonuspenaltyController {
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @RequestMapping("/employeeBonuspenalty")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView employeeBonuspenalty(int user_id) throws Exception {
        Resume resume= new Resume();
        ModelAndView model=new ModelAndView();

        Employee employee=employeeService.getEmployee(user_id);
        resume=resumeService.getResume(user_id);
        model.addObject("resume", resume);
        model.addObject("employee",employee);
        model.setViewName("employeeBonuspenalty.jsp");
        return model;
        }


}
