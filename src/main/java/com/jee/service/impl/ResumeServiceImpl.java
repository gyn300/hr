package com.jee.service.impl;

import com.jee.mapper.ResumeMapper;
import com.jee.po.Resume;
import com.jee.service.ResumeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeSevice{
    @Autowired
    private ResumeMapper resumeMapper;
    public Resume getResume(int user_id) {
        return resumeMapper.getResume(user_id);
    }

    public int insertResume(Resume resume) {
        return resumeMapper.insertResume(resume);
    }

    public int deleteResume(int id) {
        return resumeMapper.deleteResume(id);
    }

    public List<Resume> getResumeList() {
        return resumeMapper.getResumeList();
    }

    public int updateResume(Resume resume) {
        return resumeMapper.updateResume(resume);
    }
}
