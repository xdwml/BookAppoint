package edu.xidian.appoint.service.impl;
import edu.xidian.appoint.exception.AppointException;
import edu.xidian.appoint.mapper.AppointmentMapper;
import edu.xidian.appoint.mapper.BookMapper;
import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.service.AppointmentService;
import edu.xidian.appoint.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
    @Autowired//由spring装入service
    private BookMapper bookMapper;
    @Autowired//由spring装入service
    private AppointmentMapper appointmentMapper;

    //借书
    @Override
    public void BorrowBook(Appointment appointment) {
        //3.1查询预约图书ID是否还有库存
        Integer number = bookMapper.selectByPrimaryKey(appointment.getBookId()).getNumber();
        if(number<=0){
            throw new AppointException("您预约的图书已无库存");//抛出自定义异常对象
        }else {
            //3.2判断登录用户是否已经预约过该图书
            System.out.println("预约图书的学生ID："+appointment.getStudentId());
            List<Appointment> appionted=appointmentMapper.findAllByStudentId(appointment.getStudentId());
            for (int i = 0; i < appionted.size(); i++) {
                if(appionted.get(i).getBookId().equals(appointment.getBookId())){
                    throw new AppointException("您已预约过该图书");//抛出自定义异常对象
                }
            }
            //3.3 借书成功，appointment数据库插入数据，book表中图书数量-1
            appointmentMapper.insertByAppoint(appointment);//插入
            //int i=1/0;//模拟断电
            bookMapper.reduceNumberBybookId(appointment.getBookId());//减库存
            System.out.println("预约成功");
        }
    }
    //还书
    @Override
    public void ReplyBook(long bookId,long studentId) {
        //2.若有该图书，将其删去，增加图书库存
        appointmentMapper.deleteBybookId(bookId);//删去借阅的图书
        //int i=1/0;//模拟异常
        bookMapper.addNumberBybookId(bookId);//增加归还的图书number
        //2.1判断根据用户id的提交的图书id与查询的图书id是否一致
        //if(appointmentMapper.selectByBookIdAndStudentId(bookId,studentId)>0){
        // else {   throw new AppointException("还书失败");
    }
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
