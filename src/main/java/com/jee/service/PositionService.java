package com.jee.service;


import com.jee.po.Department;
import com.jee.po.Position;

import java.util.List;


public interface PositionService {
    public Position getPosition(int id);
    public int insertPosition(Position position);
    public int deletePosition(int id);
    public List<Position> getPositionList(int department_id);
    public int updatePosition(Position position);
}
