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

@Controller
public class AdminAddPositionController {
    @Autowired
    private PositionServiceImpl positionService;


    @RequestMapping("/addPosition")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public String addPosition(String positionName,int department_id) throws Exception {
        System.out.println(department_id);
        Position position=new Position();
        position.setDepartment_id(department_id);
        position.setPositionName(positionName);
        positionService.insertPosition(position);

        return "redirect:/adminGetDepartmentList.action";
    }


}
