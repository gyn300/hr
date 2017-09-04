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
import java.util.Date;

@Controller
public class OffWorkTimeController {
    @Autowired
    private AttendanceServiceImpl attendanceService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/offWorkTime")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView offWorkTime (HttpServletRequest request) throws Exception {
        ModelAndView model=new ModelAndView();
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();
        Attendance attendance=new Attendance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=df.parse(df.format(new Date()));
        //规定下班时间
        Date rgOffWorkTime=df2.parse(df.format(new Date())+" 17:30:00");

        Date offWorkTime=df2.parse(df2.format(new Date()));
        attendance.setDate(date);
        attendance.setUser_id(user_id);
        attendance=attendanceService.getAttendance(attendance);
        Date workTime=attendance.getWorkTime();
        if(attendance==null){//表示今天还没打卡
            attendance=new Attendance();
            if(rgOffWorkTime.getTime()>offWorkTime.getTime() ){
                attendance.setLeaveEarlyStatus(1);//1表示早退
            }
            attendance.setDate(date);
            attendance.setUser_id(user_id);
            attendance.setOffWorkTime(offWorkTime);
            attendanceService.insertAttendance(attendance);
            model.addObject("data","签到成功");
        }else {
            if(attendance.getOffWorkTime()!=null) {
                model.addObject("data", "签到失败,原因:已签到");
            }else{
                if(rgOffWorkTime.getTime()>offWorkTime.getTime() ){
                    attendance.setLeaveEarlyStatus(1);//1表示早退
                }
                attendance.setOffWorkTime(offWorkTime);
                attendanceService.updateAttendance(attendance);
                model.addObject("data","签到成功");
            }
        }
        model.setViewName("employeemanage.jsp");
        return model;
    }

}
