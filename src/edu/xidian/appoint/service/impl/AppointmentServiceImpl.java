package edu.xidian.appoint.service.impl;

import edu.xidian.appoint.mapper.AppointmentMapper;
import edu.xidian.appoint.mapper.BookMapper;
import edu.xidian.appoint.mapper.StudentMapper;
import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired
    private AppointmentMapper appointmentMapper;
    //通过一个学生ID查询已经预约了哪些书。
    @Override
    public List<Appointment> getAppointByStu(long studentId) {//DOTO
        return appointmentMapper.quaryAndReturn(studentId);

    }


    //通过图书ID和学生ID预约书籍，并插入
    @Override
    public void saveOrUpdate(Appointment appointment) {

        appointmentMapper.insert(appointment);

    }


}
