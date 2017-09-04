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
import javax.servlet.http.HttpSession;

@Controller
public class QuitController {

    @RequestMapping("/quit")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView quit(HttpServletRequest request) throws Exception {

            ModelAndView model=new ModelAndView();
            HttpSession session=request.getSession();
            session.removeAttribute("user_name");
            session.invalidate();
            model.setViewName("login.jsp");
            return model;
        }


}
