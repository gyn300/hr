package com.jee.mapper;


import com.jee.po.Attendance;
import com.jee.po.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryMapper {
    public Salary getSalary(Salary salary);
    public int insertSalary(Salary salary);
    public int deleteSalary(int id);
    public List<Salary> getSalaryList();
    public int updateSalary(Salary salary);

}
