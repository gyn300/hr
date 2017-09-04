package com.jee.mapper;


import com.jee.po.Attendance;
import com.jee.po.Objection;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectionMapper {
    public List<Objection> getObjectionList(int user_id);
    public int insertObjection(Objection objection);
    public int deleteObjection(int id);
    public List<Objection> getAllObjectionList();
    public int updateObjection(Objection objection);

}
