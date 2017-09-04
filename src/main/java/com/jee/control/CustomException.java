package com.jee.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class CustomException implements HandlerExceptionResolver {

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        String exceptionMsg = "";

        if (e instanceof NullPointerException) {
            exceptionMsg = "代码出现空指针";
        } else {
            exceptionMsg = "其他异常";
        }
        ModelAndView mv = new ModelAndView();
        mv.setViewName("error.jsp");
        mv.addObject("errorMsg", exceptionMsg);
        return mv;
    }
}
