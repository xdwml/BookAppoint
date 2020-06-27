package edu.xidian.appoint.web.controller;

import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.model.Book;
import edu.xidian.appoint.model.Student;
import edu.xidian.appoint.service.AppointmentService;
import edu.xidian.appoint.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("books")
public class AppointmentController {
    @Autowired//由spring装入service
    private IBookService bookService;
    @Autowired//由spring装入service
    private AppointmentService appointService;

    //用户：借阅图书
    @RequestMapping("/borrow")
    public String borrow(Long id, Model model, HttpServletRequest request){
        System.out.println("借阅图书ID："+id);
        //通过session找到用户id
        HttpSession session = request.getSession();
        Student user=(Student) session.getAttribute("user");
        //System.out.println("用户session:"+user);
        Book book=bookService.findByID(id);
        System.out.println("借阅图书："+book);//打印商品在控制台
        //图书
        Appointment appointment=new Appointment();
        appointment.setStudentId(user.getStudentId());
        appointment.setBookId(id);//从页面拿到bookid
        appointment.setAppointTime(new Date());
        appointment.setBook(book);
        System.out.println("确认借阅图书："+appointment);//打印商品在控制台
        //商品不为空就存储
        model.addAttribute("appointment",appointment);
        //存在数据库中
        appointService.saveOrUpdate(appointment);
        System.out.println("借阅成功！");
        return "forward:list.do";
        //return "forward:appoint.do";
    }
    //用户：查询已借阅
    @RequestMapping("/appoint")
    public String appoint(Model model, HttpServletRequest request){
        //通过session找到用户id
        HttpSession session = request.getSession();
        Student user=(Student) session.getAttribute("user");
        Long username=user.getStudentId();
        System.out.println("用户id的借阅图书："+username);
        //1.查数据
        List<Appointment> appointList=appointService.getAppointByStu(username);
        System.out.println("查询用户ID借阅的图书："+appointList);//打印查出的图书在控制台
        // 2.存数据
        model.addAttribute("appointList", appointList);
        return "books/appoint";

    }

    /*@RequestMapping("/borrow")
    public String borrow(Long id, Model model, HttpServletRequest request){
        System.out.println("借阅图书ID："+id);
        //通过session找到用户id
        HttpSession session = request.getSession();
        Student user=(Student) session.getAttribute("user");
        System.out.println("用户session:"+user);
        Book book=bookService.findByID(id);
        System.out.println("借阅图书："+book);//打印商品在控制台
        //图书
        Appointment appointment=new Appointment();
        appointment.setStudentId(user.getStudentId());
        appointment.setBookId(id);//从页面拿到bookid
        appointment.setAppointTime(new Date());
        appointment.setBook(book);
        System.out.println("确认借阅图书："+appointment);//打印商品在控制台
        //商品不为空就存储

        model.addAttribute("appointment",appointment);

        return "books/borrow";
    }*/
    //插入借阅数据
    /*@RequestMapping("/update")
    public String update(Appointment appointment,Model model){

        System.out.println("成功借阅："+appointment);
        //存在数据库中
        appointService.saveOrUpdate(appointment);
        return "forward:list.do";
    }*/




}
