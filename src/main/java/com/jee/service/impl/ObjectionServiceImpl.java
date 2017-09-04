package com.jee.service.impl;

import com.jee.mapper.AttendanceMapper;
import com.jee.mapper.ObjectionMapper;
import com.jee.po.Attendance;
import com.jee.po.Objection;
import com.jee.service.AttendanceService;
import com.jee.service.ObjectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObjectionServiceImpl implements ObjectionService {
    @Autowired
    private ObjectionMapper objectionMapper;


    public List<Objection> getObjectionList(int user_id) {
        return objectionMapper.getObjectionList(user_id);
    }

    public int insertObjection(Objection objection) {
        return objectionMapper.insertObjection(objection);
    }

    public int deleteObjection(int id) {
        return objectionMapper.deleteObjection(id);
    }

    public List<Objection> getAllObjectionList() {
        return objectionMapper.getAllObjectionList();
    }

    public int updateObjection(Objection objection) {
        return objectionMapper.updateObjection(objection);
    }
}
