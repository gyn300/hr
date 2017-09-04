package com.jee.mapper;


import com.jee.po.Performance;
import com.jee.po.Salary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PerformanceMapper {

    public int insertPerformance(Performance performance);
    public int deletePerformance(int id);
    public List<Performance> getPerformanceList(int user_id);
    public List<Performance> getAllPerformanceList();
    public int updatePerformance(Performance performance);

}
