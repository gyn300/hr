package com.jee.control;

import com.jee.mapper.InterviewMapper;
import com.jee.mapper.ResumeMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Interview;
import com.jee.po.Resume;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FeedbackController {
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private InterviewServiceImpl interviewService;
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/feedBack")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView feedBack(HttpServletRequest request) throws Exception {

        HttpSession session = request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();
        Resume resume=resumeService.getResume(user_id);
        Interview interview=interviewService.getInterview(user_id);
        ModelAndView model=new ModelAndView();
        model.addObject("resume",resume);
        model.addObject("interview",interview);
        model.setViewName("feedback.jsp");
        return model;

    }

}
