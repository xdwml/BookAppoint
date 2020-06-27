package edu.xidian.appoint.service;

import edu.xidian.appoint.model.Appointment;
import java.util.List;

public interface AppointmentService {


    /*
     * 查看某学生预约的所有图书
     *
     */
    public List<Appointment> getAppointByStu(long studentId);
    //通过图书id和学号预约图书
    public void saveOrUpdate(Appointment appointment);


}
