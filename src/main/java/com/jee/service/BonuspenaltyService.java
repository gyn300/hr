package com.jee.service;


import com.jee.po.Attendance;
import com.jee.po.Bonuspenalty;

import java.util.List;


public interface BonuspenaltyService {
    public Bonuspenalty getBonuspenalty(int id);
    public int insertBonuspenalty(Bonuspenalty bonuspenalty);
    public int deleteBonuspenalty(int id);
    public List<Bonuspenalty> getBonuspenaltyList(int user_id);
    public List<Bonuspenalty> getAllBonuspenaltyList();
    public int updateBonuspenalty(Bonuspenalty bonuspenalty);
}
