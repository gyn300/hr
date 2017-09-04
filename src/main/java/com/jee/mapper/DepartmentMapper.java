package com.jee.mapper;


import com.jee.po.Attendance;
import com.jee.po.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    public Department getDepartment(int id);
    public int insertDepartment(Department department);
    public int deleteDepartment(int id);
    public List<Department> getDepartmentList();
    public List<Department> getOnlyDepartmentList();
    public int updateDepartment(Department department);
}
