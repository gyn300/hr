package com.jee.control;

import com.jee.mapper.InterviewMapper;
import com.jee.mapper.ResumeMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Interview;
import com.jee.po.Resume;
import com.jee.service.impl.InterviewServiceImpl;
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
public class InsertInterviewController {
    @Autowired
    private InterviewServiceImpl interviewService;

    @RequestMapping("/insertInterview")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView insertInterview(String interviewTime,int user_id) throws Exception {

        Interview interview=new Interview();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time=df.parse(interviewTime);
        interview.setUser_id(user_id);
        interview.setInterviewTime(time);
        ModelAndView model=new ModelAndView();

            if (interviewService.insertInterview(interview) == 1) {

                model.addObject("data", "添加成功");
            } else {
                model.addObject("data", "添加失败");
            }
            model.setViewName("admincheckresume.jsp");
            return model;


    }


}
