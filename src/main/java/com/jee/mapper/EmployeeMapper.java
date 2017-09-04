package com.jee.mapper;


import com.jee.po.Employee;
import com.jee.po.Interview;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeMapper {
    public Employee getEmployee(int user_id);
    public int insertEmployee(Employee employee);
    public int deleteEmployee(int id);
    public List<Employee> getEmployeeList();
    public int updateEmployee(Employee employee);
}
