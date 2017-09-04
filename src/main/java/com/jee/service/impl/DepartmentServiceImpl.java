package com.jee.service.impl;

import com.jee.mapper.AttendanceMapper;
import com.jee.mapper.DepartmentMapper;
import com.jee.po.Attendance;
import com.jee.po.Department;
import com.jee.service.AttendanceService;
import com.jee.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDepartment(int id) {
        return departmentMapper.getDepartment(id);
    }

    public int insertDepartment(Department department) {
        return departmentMapper.insertDepartment(department);
    }

    public int deleteDepartment(int id) {
        return departmentMapper.deleteDepartment(id);
    }

    public List<Department> getDepartmentList() {
        return departmentMapper.getDepartmentList();
    }

    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    public List<Department> getOnlyDepartmentList() {
        return departmentMapper.getOnlyDepartmentList();
    }
}
