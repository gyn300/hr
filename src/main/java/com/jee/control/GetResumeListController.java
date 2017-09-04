package com.jee.control;

import com.jee.mapper.ResumeMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Resume;
import com.jee.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GetResumeListController {
    @Autowired
    private ResumeServiceImpl resumeService;

    @RequestMapping("/getResumeList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getResumeList() throws Exception {
        List<Resume> resumes=resumeService.getResumeList();
        ModelAndView model=new ModelAndView();
        model.addObject("resumes",resumes);
        model.setViewName("resumelist.jsp");
        return model;

    }

}
