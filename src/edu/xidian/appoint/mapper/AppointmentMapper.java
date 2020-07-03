package edu.xidian.appoint.mapper;

import edu.xidian.appoint.model.Appointment;
import java.util.List;

public interface AppointmentMapper {

    //插入
    int insertByAppoint(Appointment appointment);
    //通过主键删除
    int deleteBybookId(long bookId);

    //通过主键查询
    int selectByBookIdAndStudentId(long bookId, long studentId);
    //通过主键BookId查询
    Appointment selectByBookId(long bookId);
    Appointment selectByStudentId(long studentId);
    //通过一个学生ID查询已经预约了哪些书。
    List<Appointment> findAllByStudentId(long studentId);



}