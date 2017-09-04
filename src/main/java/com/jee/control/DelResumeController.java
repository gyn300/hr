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
public class DelResumeController {
    @Autowired
    private ResumeServiceImpl resumeService;

    @RequestMapping("/delResume")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public String delResume(int user_id) throws Exception {
        Resume resume=resumeService.getResume(user_id);

        resumeService.deleteResume(resume.getId());
        ModelAndView model=new ModelAndView();


        return "redirect:/getResumeList.action";

    }

}
