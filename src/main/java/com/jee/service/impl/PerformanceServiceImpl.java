package com.jee.service.impl;

import com.jee.mapper.PerformanceMapper;
import com.jee.mapper.ResumeMapper;
import com.jee.po.Performance;
import com.jee.po.Resume;
import com.jee.service.PerformanceService;
import com.jee.service.ResumeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerformanceServiceImpl implements PerformanceService{
    @Autowired
    private PerformanceMapper performanceMapper;


    public int insertPerformance(Performance performance) {
        return performanceMapper.insertPerformance(performance);
    }

    public int deletePerformance(int id) {
        return performanceMapper.deletePerformance(id);
    }

    public List<Performance> getPerformanceList(int user_id) {
        return performanceMapper.getPerformanceList(user_id);
    }

    public List<Performance> getAllPerformanceList() {
        return performanceMapper.getAllPerformanceList();
    }


    public int updatePerformance(Performance performance) {
        return performanceMapper.updatePerformance(performance);
    }
}
