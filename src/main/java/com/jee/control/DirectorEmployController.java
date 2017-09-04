package com.jee.control;

import com.jee.po.Employee;
import com.jee.po.Interview;
import com.jee.po.Resume;
import com.jee.po.User;
import com.jee.service.impl.EmployeeServiceImpl;
import com.jee.service.impl.InterviewServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
import com.jee.service.impl.UserServiceImpl;
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
public class DirectorEmployController {
    @Autowired
    private InterviewServiceImpl interviewService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @RequestMapping("/directorEmploy")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView directorEmploy(int user_id,int employStatus) throws Exception {
        Interview interview=interviewService.getInterview(user_id);
        User user=userService.getUserFromId(user_id);
        //1表示普通员工
        user.setStatus(1);
        Resume resume=resumeService.getResume(user_id);
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date inductionTime=sdf.parse(sdf.format(new Date()));
        Employee employee=new Employee();
        employee.setAge(resume.getAge());
        employee.setDepartment(resume.getDepartment());
        employee.setName(resume.getName());
        employee.setPosition(resume.getPosition());
        employee.setUser_id(user_id);
        employee.setInductionTime(inductionTime);
        ModelAndView model=new ModelAndView();
        interview.setEmployStatus(employStatus);
        interview.setInterviewStatus(1);
        if(interviewService.updateInterview(interview)==1&&userService.updateUser(user)==1&&employeeService.insertEmployee(employee)==1){

            model.addObject("data","操作成功");
        }else{
            model.addObject("data","操作失败");
        }
        model.setViewName("directornotice.jsp");
        return model;

    }

}
