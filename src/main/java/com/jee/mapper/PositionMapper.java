package com.jee.mapper;


import com.jee.po.Department;
import com.jee.po.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionMapper {
    public Position getPosition(int id);
    public int insertPosition(Position position);
    public int deletePosition(int id);
    public List<Position> getPositionList(int department_id);
    public int updatePosition(Position position);
}
