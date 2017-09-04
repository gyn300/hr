package com.jee.control;

import com.jee.mapper.InterviewMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Educate;
import com.jee.po.Interview;
import com.jee.po.Resume;
import com.jee.po.User;
import com.jee.service.impl.*;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private InterviewServiceImpl interviewService;
    @Autowired
    private EducateServiceImpl educateService;
    @Autowired
    private EmployeeServiceImpl employeeService;
    @Autowired
    private ResumeServiceImpl resumeService;
    @RequestMapping("/login")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)
    public ModelAndView login(HttpServletRequest request,String user_name,String user_pwd) throws Exception {

        User user=null;

        ModelAndView model=new ModelAndView();

        if(user_name!=null) {

            user = userService.getUser(user_name);

            if(user!=null){
                if(user.getUser_pwd().equals(user_pwd)) {
                model.addObject("user", user);
                //0位游客
                if(user.getStatus()==0) {
                    Interview interview=interviewService.getInterview(user.getId());
                    if(interview!=null){
                        model.addObject("num",1);
                    }else{
                        model.addObject("num",0);
                    }

                    model.setViewName("visitormanage.jsp");

                }if(user.getStatus()==1) {//1为普通员工



                        model.setViewName("employeemanage.jsp");

                    }
                else if(user.getStatus()==3){//3为管理员
                    model.setViewName("manage.jsp");
                    //2为主管
                }else if(user.getStatus()==2){
                        List<Interview> interviews=interviewService.getInterviewList();
                        List<Interview> interviews1=new ArrayList<Interview>();
                        int user_id=user.getId();
                        String department=employeeService.getEmployee(user_id).getDepartment();
                        Resume resume=null;
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

                    model.setViewName("directormanage.jsp");

                }
                }else {
                    model.addObject("data", "账号密码错误");
                    model.setViewName("failed.jsp");
                }
            }else{
                model.addObject("data", "账号密码错误");
                model.setViewName("failed.jsp");
             }
        }
        HttpSession session = request.getSession();
        session.setAttribute("user_name",user_name);
        return model;
    }


}
