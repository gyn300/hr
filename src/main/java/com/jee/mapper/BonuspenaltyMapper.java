package com.jee.mapper;


import com.jee.po.Attendance;
import com.jee.po.Bonuspenalty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BonuspenaltyMapper {
    public Bonuspenalty getBonuspenalty(int id);
    public int insertBonuspenalty(Bonuspenalty bonuspenalty);
    public int deleteBonuspenalty(int id);
    public List<Bonuspenalty> getBonuspenaltyList(int user_id);
    public List<Bonuspenalty> getAllBonuspenaltyList();
    public int updateBonuspenalty(Bonuspenalty bonuspenalty);
}
