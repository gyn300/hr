package com.jee.control;

import com.jee.po.Educate;
import com.jee.service.impl.EducateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DelEducateController {
    @Autowired
    private EducateServiceImpl educateService;

    @RequestMapping("/delEducate")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public String delEducate(int id) throws Exception {
            educateService.deleteEducate(id);

            return "redirect:/getEaducateList.action";
    }

}
