package edu.xidian.appoint.service.impl;
import edu.xidian.appoint.mapper.AppointmentMapper;
import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Override
    public int insertByAppoint(Appointment appointment) {
        return appointmentMapper.insertByAppoint(appointment);
    }

    @Override
    public int deleteBybookId(long bookId) {
        return appointmentMapper.deleteBybookId(bookId);
    }

    @Override
    public int selectByBookIdAndStudentId(long bookId, long studentId) {
        return appointmentMapper.selectByBookIdAndStudentId(bookId,studentId);
    }

    @Override
    public Appointment selectByBookId(long bookId) {
        return appointmentMapper.selectByBookId(bookId);
    }

    @Override
    public Appointment selectByStudentId(long studentId) {
        return appointmentMapper.selectByStudentId(studentId);
    }

    //通过一个学生ID查询已经预约了哪些书。
    @Override
    public List<Appointment> findAllByStudentId(long studentId) {//DOTO
        return appointmentMapper.findAllByStudentId(studentId);
    }

}
