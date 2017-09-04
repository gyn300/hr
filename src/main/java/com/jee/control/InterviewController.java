package com.jee.control;

import com.jee.mapper.ResumeMapper;
import com.jee.po.Resume;
import com.jee.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InterviewController {
    @Autowired
    private ResumeServiceImpl resumeService;

    @RequestMapping("/interview")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView interview(int user_id) throws Exception {
        Resume resume=resumeService.getResume(user_id);
        ModelAndView model=new ModelAndView();
        model.addObject("resume",resume);
        model.setViewName("admincheckresume.jsp");
        return model;

    }

}
