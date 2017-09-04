package com.jee.control;

import com.jee.po.Objection;
import com.jee.po.Resume;
import com.jee.service.impl.ObjectionServiceImpl;
import com.jee.service.impl.ResumeServiceImpl;
import com.jee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InsertObjectionController {
    @Autowired
    private ObjectionServiceImpl objectionService;

    @RequestMapping("/insertObjection")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView insertObjection(Objection objection) throws Exception {
        ModelAndView model = new ModelAndView();

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM");
        List<Objection> objections=objectionService.getObjectionList(objection.getUser_id());
        boolean flag=false;//true表示本月已经添加objection
        for (Objection obj:objections
             ) {
            if(df.format(obj.getDate()).equals(df.format(objection.getDate()))){
                flag=true;
            }
        }
        if(!flag){
            if(objectionService.insertObjection(objection)!=0){
                model.addObject("data","添加异议成功");
            }else {
                model.addObject("data","添加异议失败");
            }
        }else {
            model.addObject("data","添加异议失败,原因:已添加");
        }
        model.setViewName("employeesalary.jsp");
        return  model;
    }
}
