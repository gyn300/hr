package com.jee.control;

import com.jee.po.Department;
import com.jee.po.Educate;
import com.jee.service.impl.EducateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UpdateEducateController {
    @Autowired
    private EducateServiceImpl educateService;

    @RequestMapping("/updateEducate")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView updateEducate(int id,String educateName,String educateTime,String educateDepartment) throws Exception {
        ModelAndView model=new ModelAndView();

        Educate educate=new Educate();
        educate.setId(id);
        educate.setEducateName(educateName);
        educate.setEducateDepartment(educateDepartment);
        SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd");
        educate.setEducateTime(df.parse(educateTime));
        if(educateService.updateEducate(educate)==0){
            model.addObject("data","修改失败");
        }else {
            model.addObject("data","修改成功");
        }

            model.setViewName("updateeducate.jsp");
        return model;
    }

}
