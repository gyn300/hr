package com.jee.service.impl;

import com.jee.mapper.AttendanceMapper;
import com.jee.mapper.BonuspenaltyMapper;
import com.jee.po.Attendance;
import com.jee.po.Bonuspenalty;
import com.jee.service.AttendanceService;
import com.jee.service.BonuspenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonuspenaltyServiceImpl implements BonuspenaltyService {
    @Autowired
    private BonuspenaltyMapper bonuspenaltyMapper;

    public Bonuspenalty getBonuspenalty(int id) {
        return bonuspenaltyMapper.getBonuspenalty(id);
    }

    public int insertBonuspenalty(Bonuspenalty bonuspenalty) {
        return bonuspenaltyMapper.insertBonuspenalty(bonuspenalty);
    }

    public int deleteBonuspenalty(int id) {
        return bonuspenaltyMapper.deleteBonuspenalty(id);
    }

    public List<Bonuspenalty> getBonuspenaltyList(int user_id) {
        return bonuspenaltyMapper.getBonuspenaltyList(user_id);
    }

    public List<Bonuspenalty> getAllBonuspenaltyList() {
        return bonuspenaltyMapper.getAllBonuspenaltyList();
    }

    public int updateBonuspenalty(Bonuspenalty bonuspenalty) {
        return 0;
    }
}
