package com.jee.control;

import com.jee.po.Department;
import com.jee.po.Educate;
import com.jee.service.impl.DepartmentServiceImpl;
import com.jee.service.impl.EducateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetEducateController {
    @Autowired
    private EducateServiceImpl educateService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @RequestMapping("/getEducate")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getEducate(int id) throws Exception {
        ModelAndView model=new ModelAndView();
        Educate educate = educateService.getEducate(id);
        List<Department> departments=departmentService.getDepartmentList();
        List<Educate> educates=educateService.getEducateList();
        model.addObject("educates",educates);
        model.addObject("departments",departments);
        model.addObject("educate",educate);
        model.setViewName("updateeducate.jsp");
        return model;
    }

}
