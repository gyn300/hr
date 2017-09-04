package com.jee.control;

import com.jee.mapper.ResumeMapper;
import com.jee.po.Department;
import com.jee.po.Resume;
import com.jee.service.ResumeSevice;
import com.jee.service.impl.DepartmentServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CheckResumeController {
    @Autowired
    private ResumeServiceImpl resumeSevice;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @RequestMapping("/checkResume")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView checkResume(int user_id) throws Exception {
        List<Department> departments=departmentService.getDepartmentList();
        Resume resume=resumeSevice.getResume(user_id);
        resume.setCheckStatus(1);
        resumeSevice.updateResume(resume);
        ModelAndView model=new ModelAndView();
        model.addObject("resume",resume);
        if(departments!=null){
            model.addObject("departments",departments);
        }
        model.setViewName("admincheckresume.jsp");
        return model;

    }

}
