package com.jee.service.impl;

import com.jee.mapper.EmployeeMapper;
import com.jee.mapper.InterviewMapper;
import com.jee.po.Employee;
import com.jee.po.Interview;
import com.jee.service.EmployeeService;
import com.jee.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    public Employee getEmployee(int user_id) {
        return employeeMapper.getEmployee(user_id);
    }

    public int insertEmployee(Employee employee) {
        return employeeMapper.insertEmployee(employee);
    }

    public int deleteEmployee(int id) {
        return employeeMapper.deleteEmployee(id);
    }

    public List<Employee> getEmployeeList() {
        return employeeMapper.getEmployeeList();
    }

    public int updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }


   }
