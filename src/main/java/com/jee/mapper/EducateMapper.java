package com.jee.mapper;


import com.jee.po.Educate;
import com.jee.po.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducateMapper {
    public Educate getEducate(int id);
    public int insertEducate(Educate educate);
    public int deleteEducate(int id);
    public List<Educate> getEducateList();
    public int updateEducate(Educate educate);
}
