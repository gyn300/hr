package com.jee.service;


import com.jee.po.Educate;
import com.jee.po.Employee;

import java.util.List;


public interface EducateService {
    public Educate getEducate(int id);
    public int insertEducate(Educate educate);
    public int deleteEducate(int id);
    public List<Educate> getEducateList();
    public int updateEducate(Educate educate);
}
