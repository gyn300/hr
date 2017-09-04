package com.jee.control;

import com.jee.mapper.ResumeMapper;
import com.jee.mapper.UserMapper;
import com.jee.po.Resume;
import com.jee.po.User;
import com.jee.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UpdateVisitorPwdController {

    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("/updateVisitorPwd")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView updateVisitorPwd(String user_name,String password_old,String password) throws Exception {

            ModelAndView model=new ModelAndView();
            User user=userService.getUser(user_name);
            if(user.getUser_pwd().equals(password_old)){
                user.setUser_pwd(password);

                if (userService.updateUser(user) == 1) {

                    model.addObject("data", "修改成功");
                    model.setViewName("login.jsp");
                }else {
                    model.setViewName("updatevisitor.jsp");
                    model.addObject("data", "修改失败");
                }

            }else {
                model.addObject("data","原密码错误");
                model.setViewName("updatevisitor.jsp");
            }
            return model;
        }


}
