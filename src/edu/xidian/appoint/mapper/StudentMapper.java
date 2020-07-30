package edu.xidian.appoint.mapper;
import edu.xidian.appoint.model.Student;
public interface StudentMapper {
    Student selectByPrimaryKey(Long studentId);

}