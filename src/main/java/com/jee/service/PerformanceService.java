package com.jee.service;


import com.jee.po.Bonuspenalty;
import com.jee.po.Performance;

import java.util.List;


public interface PerformanceService {

    public int insertPerformance(Performance performance);
    public int deletePerformance(int id);
    public List<Performance> getPerformanceList(int user_id);
    public List<Performance> getAllPerformanceList();
    public int updatePerformance(Performance performance);
}
