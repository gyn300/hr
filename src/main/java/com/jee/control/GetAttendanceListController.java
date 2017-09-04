package com.jee.control;

import com.jee.po.Attendance;
import com.jee.service.impl.AttendanceServiceImpl;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class GetAttendanceListController {
    @Autowired
    private AttendanceServiceImpl attendanceService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/getAttendanceList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView getAttendanceList(HttpServletRequest request,String sDate) throws Exception {
        ModelAndView model=new ModelAndView();
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        List<Attendance> attendances=attendanceService.getAttendanceList(user_id);
        List<Attendance> sAttendances=new ArrayList<Attendance>();
        for (Attendance attendance:attendances
             ) {
            if(df.format(attendance.getDate()).contains(sDate)){
                sAttendances.add(attendance);
            }

        }
        if(sAttendances!=null) {
            model.addObject("sAttendances", sAttendances);
        }
        model.setViewName("employeeattendancelist.jsp");
        return model;
    }


}
