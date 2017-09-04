package com.jee.service.impl;

import com.jee.mapper.DepartmentMapper;
import com.jee.mapper.PositionMapper;
import com.jee.po.Department;
import com.jee.po.Position;
import com.jee.service.DepartmentService;
import com.jee.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionMapper positionMapper;

    public Position getPosition(int id) {
        return positionMapper.getPosition(id);
    }

    public int insertPosition(Position position) {
        return positionMapper.insertPosition(position);
    }

    public int deletePosition(int id) {
        return positionMapper.deletePosition(id);
    }

    public List<Position> getPositionList(int department_id) {
        return positionMapper.getPositionList(department_id);
    }

    public int updatePosition(Position position) {
        return positionMapper.updatePosition(position);
    }
}
