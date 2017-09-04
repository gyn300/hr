package com.jee.control;

import com.jee.mapper.ResumeMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Resume;
import com.jee.service.impl.ResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class UpdateResumeController {
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private  UserMapper userMapper;
    @RequestMapping("/updateResume")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView updateResume(Resume resume,String user_name) throws Exception {


        if(resume.getSex().equals("0")){
            resume.setSex("女");
        }else {
            resume.setSex("男");
         }

        int user_id=userMapper.getUser(user_name).getId();
        resume.setUser_id(user_id);

        ModelAndView model=new ModelAndView();



            model.addObject("resume", resume);
            if (resumeService.updateResume(resume) == 1) {

                model.addObject("data", "修改成功");
            } else {
                model.addObject("data", "修改失败");
            }
            model.setViewName("addjob.jsp");
            return model;
        }


}
