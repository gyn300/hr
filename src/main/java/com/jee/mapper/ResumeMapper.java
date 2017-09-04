package com.jee.mapper;


import com.jee.po.Resume;
import com.jee.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeMapper {
    public Resume getResume(int user_id);
    public int insertResume(Resume resume);
    public int deleteResume(int id);
    public List<Resume> getResumeList();
    public int updateResume(Resume resume);
}
