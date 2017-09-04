package com.jee.control;

import com.jee.po.Department;
import com.jee.po.Resume;
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
public class DirectorCheckResumeController {
    @Autowired
    private ResumeServiceImpl resumeSevice;
    @Autowired
    private DepartmentServiceImpl departmentService;

    @RequestMapping("/directorCheckResume")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView directorCheckResume(int user_id) throws Exception {
        Resume resume=resumeSevice.getResume(user_id);
        List<Department> departments=departmentService.getDepartmentList();

        ModelAndView model=new ModelAndView();
        model.addObject("resume",resume);
        if(departments!=null){
            model.addObject("departments",departments);
        }
        model.setViewName("directorcheckresume.jsp");
        return model;

    }

}
