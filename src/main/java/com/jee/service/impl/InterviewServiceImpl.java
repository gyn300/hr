package com.jee.service.impl;

import com.jee.mapper.InterviewMapper;
import com.jee.po.Interview;
import com.jee.service.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewServiceImpl implements InterviewService {
    @Autowired
    private InterviewMapper interviewMapper;
    public Interview getInterview(int user_id) {
        return interviewMapper.getInterview(user_id);
    }

    public int insertInterview(Interview interview) {
        return interviewMapper.insertInterview(interview);
    }

    public int deleteInterview(int id) {
        return interviewMapper.deleteInterview(id);
    }

    public List<Interview> getInterviewList() {
        return interviewMapper.getInterviewList();
    }

    public int updateInterview(Interview interview) {
        return interviewMapper.updateInterview(interview);
    }
}
