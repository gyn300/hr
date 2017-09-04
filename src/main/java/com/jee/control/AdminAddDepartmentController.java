package com.jee.control;

import com.jee.po.Department;
import com.jee.po.Position;
import com.jee.service.impl.DepartmentServiceImpl;
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
public class AdminAddDepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentService;


    @RequestMapping("/addDepartment")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public String addDepartment(String departmentName) throws Exception {

        Department department=new Department();
        department.setDepartmentName(departmentName);
        departmentService.insertDepartment(department);

        return "redirect:/adminGetDepartmentList.action";
    }


}
