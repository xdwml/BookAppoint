package edu.xidian.appoint.service.impl;

import edu.xidian.appoint.mapper.StudentMapper;
import edu.xidian.appoint.model.Student;
import edu.xidian.appoint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;//自动注入dao,mapper就是dao

    @Override
    public Student selectByPrimaryKey(Long studentId) {
        return studentMapper.selectByPrimaryKey(studentId);
    }
}
