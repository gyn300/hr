package com.jee.control;

import com.jee.po.Attendance;
import com.jee.po.Resume;
import com.jee.service.impl.AttendanceServiceImpl;
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

@Controller
public class WorkTimeController {
    @Autowired
    private AttendanceServiceImpl attendanceService;
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/workTime")
    @Transactional(isolation = Isolation.DEFAULT,
            propagation = Propagation.REQUIRED)

    public ModelAndView workTime(HttpServletRequest request) throws Exception {
        ModelAndView model=new ModelAndView();
        HttpSession session=request.getSession();
        String user_name= (String) session.getAttribute("user_name");
        int user_id=userService.getUser(user_name).getId();
        Attendance attendance=new Attendance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=df.parse(df.format(new Date()));
        //规定上班时间
        Date rgWorkTime=df2.parse(df.format(new Date())+" 09:00:00");

        Date workTime=df2.parse(df2.format(new Date()));

        attendance.setDate(date);
        attendance.setUser_id(user_id);
        attendance=attendanceService.getAttendance(attendance);

        if(attendance==null){//表示今天还没打卡
            attendance=new Attendance();
            if(rgWorkTime.getTime() < workTime.getTime()){
                attendance.setLateStatus(1);//1表示迟到
            }
            attendance.setDate(date);
            attendance.setUser_id(user_id);
            attendance.setWorkTime(workTime);
            attendanceService.insertAttendance(attendance);
            model.addObject("data","签到成功");
        }else {
            model.addObject("data","签到失败,原因:已签到");
        }
        model.setViewName("employeemanage.jsp");
        return model;
    }


}
