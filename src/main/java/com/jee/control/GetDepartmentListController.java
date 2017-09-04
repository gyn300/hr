package com.jee.control;

import com.jee.po.Attendance;
import com.jee.po.Department;
import com.jee.po.Position;
import com.jee.service.impl.AttendanceServiceImpl;
import com.jee.service.impl.DepartmentServiceImpl;
import com.jee.service.impl.PositionServiceImpl;
import com.jee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GetDepartmentListController {
    @Autowired
    private DepartmentServiceImpl departmentService;
    @Autowired
    private PositionServiceImpl positionService;

    @RequestMapping("/getDepartmentList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getDepartmentList(@RequestParam(defaultValue ="0")int department_id) throws Exception {
        ModelAndView model=new ModelAndView();
        List<Department> departments=departmentService.getDepartmentList();
        System.out.println(department_id);
        if(department_id!=0){
            List<Position> positions=positionService.getPositionList(department_id);

            if(positions!=null) {
                model.addObject("positions", positions);
            }
        }
        if(departments!=null) {
            model.addObject("departments", departments);
        }
        model.setViewName("departmentlist.jsp");
        return model;
    }


}
