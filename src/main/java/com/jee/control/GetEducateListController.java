package com.jee.control;

import com.jee.po.Department;
import com.jee.po.Educate;
import com.jee.po.Position;
import com.jee.service.impl.DepartmentServiceImpl;
import com.jee.service.impl.EducateServiceImpl;
import com.jee.service.impl.PositionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetEducateListController {
    @Autowired
    private EducateServiceImpl educateService;
    @Autowired
    private DepartmentServiceImpl departmentService;

    @RequestMapping("/getEaducateList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getEaducateList() throws Exception {
        ModelAndView model=new ModelAndView();
        List<Educate> educates=educateService.getEducateList();
        List<Department> departments=departmentService.getDepartmentList();
        model.addObject("educates",educates);
        model.addObject("departments",departments);
        model.setViewName("addeducate.jsp");
        return model;
    }


}
