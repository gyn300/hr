package com.jee.service;


import com.jee.po.Attendance;
import com.jee.po.Department;

import java.util.List;


public interface DepartmentService {
    public Department getDepartment(int id);
    public int insertDepartment(Department department);
    public int deleteDepartment(int id);
    public List<Department> getDepartmentList();
    public int updateDepartment(Department department);
    public List<Department> getOnlyDepartmentList();
}
