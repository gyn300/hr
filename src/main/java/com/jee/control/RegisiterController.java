package com.jee.control;

import com.jee.mapper.UserMapper;
import com.jee.po.User;
import com.jee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class RegisiterController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/insertUser")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)
    public ModelAndView insertUser(String user_name,String user_pwd) throws Exception {
        User user= new User();

        ModelAndView model=new ModelAndView();
        if(user_name!=null&&user_pwd!=null) {
            user.setUser_name(user_name);
            user.setUser_pwd(user_pwd);
            if (userService.getUser(user_name) == null) {
                userService.insertUser(user);

                model.addObject("user", user);
                model.setViewName("login.jsp");
            } else {
                model.addObject("data", "注册失败");
                model.setViewName("failed.jsp");
            }
        }else {
            model.addObject("data", "注册失败");
            model.setViewName("failed.jsp");
        }
        return model;
    }
}
