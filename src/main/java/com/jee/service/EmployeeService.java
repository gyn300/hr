package com.jee.service;


import com.jee.po.Employee;
import com.jee.po.Interview;

import java.util.List;


public interface EmployeeService {
    public Employee getEmployee(int user_id);
    public int insertEmployee(Employee employee);
    public int deleteEmployee(int id);
    public List<Employee> getEmployeeList();
    public int updateEmployee(Employee employee);
}
