package com.jee.service.impl;

import com.jee.mapper.EducateMapper;
import com.jee.mapper.EmployeeMapper;
import com.jee.po.Educate;
import com.jee.po.Employee;
import com.jee.service.EducateService;
import com.jee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducateServiceImpl implements EducateService {
    @Autowired
    private EducateMapper educateMapper;

    public Educate getEducate(int id) {
        return educateMapper.getEducate(id);
    }

    public int insertEducate(Educate educate) {
        return educateMapper.insertEducate(educate);
    }

    public int deleteEducate(int id) {
        return educateMapper.deleteEducate(id);
    }

    public List<Educate> getEducateList() {
        return educateMapper.getEducateList();
    }

    public int updateEducate(Educate educate) {
        return educateMapper.updateEducate(educate);
    }
}
