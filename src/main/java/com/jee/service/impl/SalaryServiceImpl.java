package com.jee.service.impl;

import com.jee.mapper.AttendanceMapper;
import com.jee.mapper.SalaryMapper;
import com.jee.po.Attendance;
import com.jee.po.Salary;
import com.jee.service.AttendanceService;
import com.jee.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryMapper salaryMapper;

    public Salary getSalary(Salary salary) {
        return salaryMapper.getSalary(salary);
    }

    public int insertSalary(Salary salary) {
        return salaryMapper.insertSalary(salary);
    }

    public int deleteSalary(int id) {
        return salaryMapper.deleteSalary(id);
    }

    public List<Salary> getSalaryList() {
        return salaryMapper.getSalaryList();
    }

    public int updateSalary(Salary salary) {
        return salaryMapper.updateSalary(salary);
    }
}
