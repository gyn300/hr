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
import java.util.List;

@Controller
public class AdminGetAttendanceListController {
    @Autowired
    private AttendanceServiceImpl attendanceService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/adminGetAttendanceList")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView adminGetAttendanceList(HttpServletRequest request,String sDate,int user_id) throws Exception {
        ModelAndView model=new ModelAndView();
        HttpSession session=request.getSession();

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
        model.setViewName("adminattendancelist.jsp");
        return model;
    }


}
