package com.jee.control;

import com.jee.mapper.ResumeMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Department;
import com.jee.po.Resume;
import com.jee.service.impl.DepartmentServiceImpl;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class InsertResumeController {
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private DepartmentServiceImpl departmentService;
    @RequestMapping("/insertResume")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView insertResume(String user_name,Resume resume) throws Exception {
        List<Department> departments=departmentService.getDepartmentList();

        if(resume.getSex().equals("0")){
            resume.setSex("女");
        }else {
            resume.setSex("男");
        }
        int user_id=userService.getUser(user_name).getId();
        resume.setUser_id(user_id);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date time=df.parse(df.format(new Date()));
        resume.setTime(time);

        ModelAndView model=new ModelAndView();


            model.addObject("resume", resume);
            if (resumeService.insertResume(resume) == 1) {

                model.addObject("data", "添加成功");
            } else {
                model.addObject("data", "添加失败");
            }
             if(departments!=null){
                 model.addObject("departments",departments);
             }
            model.setViewName("addjob.jsp");
            return model;


    }
    @RequestMapping("/judgeResume")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView judgeResume(HttpServletRequest request) throws Exception {
        List<Department> departments=departmentService.getDepartmentList();
        Resume resume=null;
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");

        ModelAndView model=new ModelAndView();
         int user_id=userService.getUser(user_name).getId();
            resume=resumeService.getResume(user_id);
            if(resume!=null){
            model.addObject("resume", resume);
            }
            if(departments!=null){
                model.addObject("departments",departments);
            }

            model.setViewName("addjob.jsp");
            return model;
        }


}
