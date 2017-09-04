package com.jee.control;

import com.jee.mapper.UserMapper;
import com.jee.po.Employee;
import com.jee.po.Resume;
import com.jee.service.impl.EmployeeServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateEmployeeDepartmentController {

    @Autowired
    private EmployeeServiceImpl employeeService;
    @RequestMapping("/updateEmployeeDepartment")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView updateEmployeeDepartment(int user_id,String department,String position) throws Exception {
            ModelAndView model=new ModelAndView();
            Employee employee=employeeService.getEmployee(user_id);

            employee.setDepartment(department);
            employee.setPosition(position);
            if(employeeService.updateEmployee(employee)!=0){
                model.addObject("data","调动成功");
            }else {
                model.addObject("data","调动失败");
            }

            model.setViewName("personneltransfer.jsp");
            return model;
        }


}
