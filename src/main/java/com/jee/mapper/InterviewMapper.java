package com.jee.mapper;


import com.jee.po.Interview;
import com.jee.po.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewMapper {
    public Interview getInterview(int user_id);
    public int insertInterview(Interview interview);
    public int deleteInterview(int id);
    public List<Interview> getInterviewList();
    public int updateInterview(Interview interview);
}
