package com.jee.control;

import com.jee.mapper.EmployeeMapper;
import com.jee.po.Educate;
import com.jee.po.Interview;
import com.jee.po.Resume;
import com.jee.po.User;
import com.jee.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DirectorNoticeController {
    @Autowired
    private InterviewServiceImpl interviewService;
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private EducateServiceImpl educateService;
    @RequestMapping("/directorNotice")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView directorNotice(HttpServletRequest request) throws Exception {
        ModelAndView model = new ModelAndView();
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        User user=userService.getUser(user_name);
        int user_id=user.getId();
        String department=employeeService.getEmployee(user_id).getDepartment();
        Resume resume=null;
        List<Interview> interviews=interviewService.getInterviewList();
        List<Interview> interviews1=new ArrayList<Interview>();
        if(interviews!=null){
            for (Interview interview:interviews
                    ) {
                resume=resumeService.getResume(interview.getUser_id());
                //判断部门
                if(resume.getDepartment().equals(department)){
                //不为0说明面试过
                if(interview.getInterviewStatus()!=0){
                    interviews1.add(interview);

                }
              }else {
                    interviews1.add(interview);
                }
            }
        }

        interviews.removeAll(interviews1);
        List<Educate> educates=educateService.getEducateList();
        List<Educate> educates1=new ArrayList<Educate>();
        if(educates!=null){
            for (Educate educate:educates
                    ) {
                    //判断部门
                if(educate.getEducateDepartment().equals(department)) {
                    //不为0说明培训过了
                    if (educate.getStatus() != 0) {
                        educates1.add(educate);

                    }
                }else {
                    educates1.add(educate);
                }
            }
        }
        educates.removeAll(educates1);
        model.addObject("educates",educates);

        model.addObject("interviews", interviews);
        model.setViewName("directornotice.jsp");
        return model;
    }

}
