package com.jee.service.impl;

import com.jee.mapper.AttendanceMapper;
import com.jee.mapper.EmployeeMapper;
import com.jee.po.Attendance;
import com.jee.po.Employee;
import com.jee.service.AttendanceService;
import com.jee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    public Attendance getAttendance(Attendance attendance) {
        return attendanceMapper.getAttendance(attendance);
    }

    public int insertAttendance(Attendance attendance) {
        return attendanceMapper.insertAttendance(attendance);
    }

    public int deleteAttendance(int id) {
        return attendanceMapper.deleteAttendance(id);
    }

    public List<Attendance> getAttendanceList(int user_id) {
        return attendanceMapper.getAttendanceList(user_id);
    }

    public int updateAttendance(Attendance attendance) {
        return attendanceMapper.updateAttendance(attendance);
    }

    public List<Attendance> getAllAttendanceList() {
        return attendanceMapper.getAllAttendanceList();
    }
}
