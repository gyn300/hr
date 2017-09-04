package com.jee.service;


import com.jee.po.Attendance;
import com.jee.po.Salary;

import java.util.List;


public interface SalaryService {
    public Salary getSalary(Salary salary);
    public int insertSalary(Salary salary);
    public int deleteSalary(int id);
    public List<Salary> getSalaryList();
    public int updateSalary(Salary salary);
}
