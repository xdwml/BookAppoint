package edu.xidian.appoint.mapper;

import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.model.AppointmentExample;
import edu.xidian.appoint.model.AppointmentKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppointmentMapper {

    int countByExample(AppointmentExample example);

    List<Appointment> quaryAndReturn(long studentId);//通过一个学生ID查询已经预约了哪些书。


    int deleteByExample(AppointmentExample example);

    int deleteByPrimaryKey(AppointmentKey key);

    int insert(Appointment record);


    int insertSelective(Appointment record);

    List<Appointment> selectByExample(AppointmentExample example);


    Appointment selectByPrimaryKey(AppointmentKey key);


    int updateByExampleSelective(@Param("record") Appointment record, @Param("example") AppointmentExample example);


    int updateByExample(@Param("record") Appointment record, @Param("example") AppointmentExample example);


    int updateByPrimaryKeySelective(Appointment record);

    int updateByPrimaryKey(Appointment record);
}