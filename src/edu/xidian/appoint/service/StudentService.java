package edu.xidian.appoint.service;

import edu.xidian.appoint.model.Student;
public interface StudentService {
    Student selectByPrimaryKey(Long studentId);
}
