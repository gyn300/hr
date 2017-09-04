package com.jee.service;


import com.jee.po.Interview;


import java.util.List;


public interface InterviewService {
    public Interview getInterview(int user_id);
    public int insertInterview(Interview interview);
    public int deleteInterview(int id);
    public List<Interview> getInterviewList();
    public int updateInterview(Interview interview);
}
