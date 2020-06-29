package edu.xidian.appoint.mapper;
import edu.xidian.appoint.model.Student;
import java.util.List;
public interface StudentMapper {
    Student selectByPrimaryKey(Long studentId);

}