package com.jee.service;


import com.jee.po.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeSevice {
    public Resume getResume(int user_id);
    public int insertResume(Resume resume);
    public int deleteResume(int id);
    public List<Resume> getResumeList();
    public int updateResume(Resume resume);
}
