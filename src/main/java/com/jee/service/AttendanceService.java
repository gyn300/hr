package com.jee.service;


import com.jee.po.Attendance;
import com.jee.po.Employee;

import java.util.List;


public interface AttendanceService {
    public Attendance getAttendance(Attendance attendance);
    public int insertAttendance(Attendance attendance);
    public int deleteAttendance(int id);
    public List<Attendance> getAttendanceList(int user_id);
    public int updateAttendance(Attendance attendance);
    public List<Attendance> getAllAttendanceList();
}
