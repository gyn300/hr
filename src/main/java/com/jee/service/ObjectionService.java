package com.jee.service;


import com.jee.po.Attendance;
import com.jee.po.Objection;

import java.util.List;


public interface ObjectionService {
    public List<Objection> getObjectionList(int user_id);
    public int insertObjection(Objection objection);
    public int deleteObjection(int id);
    public List<Objection> getAllObjectionList();
    public int updateObjection(Objection objection);
}
