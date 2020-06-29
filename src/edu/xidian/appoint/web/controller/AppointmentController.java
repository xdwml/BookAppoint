package edu.xidian.appoint.web.controller;
import edu.xidian.appoint.exception.AppointException;
import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.model.Book;
import edu.xidian.appoint.model.Student;
import edu.xidian.appoint.service.AppointmentService;
import edu.xidian.appoint.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
@Controller
@Transactional
@RequestMapping("books")
public class AppointmentController {
    @Autowired//由spring装入service
    private BookService bookService;
    @Autowired//由spring装入service
    private AppointmentService appointService;
    //用户：借阅图书
    @RequestMapping("/borrow")
    public String borrow(Long id, Model model, HttpServletRequest request){
        //1.获得用户
        System.out.println("想要借阅的图书ID：" + id);
        Student user = (Student) request.getSession().getAttribute("user");//通过session找到用户id
        Book book = bookService.selectByPrimaryKey(id);//通过id拿到借阅图书
        System.out.println("想要借阅的图书信息：" + book);//打印商品在控制台
        //2.封装图书
        Appointment appointment = new Appointment();
        appointment.setStudentId(user.getStudentId());//通过session拿到用户id
        appointment.setBookId(id);//从页面拿到bookid
        appointment.setAppointTime(new Date());
        appointment.setBook(book);
        System.out.println("确认所借阅图书：" + appointment);//打印商品在控制台
        //3.借书逻辑，存取数据库中
        //3.1查询预约图书ID是否还有库存
        Integer number = bookService.selectByPrimaryKey(appointment.getBookId()).getNumber();
        if(number<=0){
            throw new AppointException("您预约的图书已无库存");
        }else {
            //3.2判断登录用户是否已经预约过该图书
            System.out.println("预约图书的学生ID："+appointment.getStudentId());
            List<Appointment> appionted=appointService.findAllByStudentId(appointment.getStudentId());
            for (int i = 0; i < appionted.size(); i++) {
                if(appionted.get(i).getBookId().equals(appointment.getBookId())){
                    throw new AppointException("您已预约过该图书");
                }
            }
            //3.3 借书成功，appointment数据库插入数据，book表中图书数量-1
            appointService.insertByAppoint(appointment);//插入
            bookService.reduceNumberBybookId(appointment.getBookId());//减库存
            System.out.println("预约成功");
        }
        //4.将数据返回视图层显示，转发给预约图书页面
        model.addAttribute("appointment", appointment);
        return "forward:appoint.do";
    }
    //用户：查询已借阅
    @RequestMapping("/appoint")
    public String appoint(Model model, HttpServletRequest request){
        //1.通过session找到用户id
        Student user=(Student) request.getSession().getAttribute("user");
        Long username=user.getStudentId();
        System.out.println("用户id的借阅图书："+username);
        //2.查数据
        List<Appointment> appointList=appointService.findAllByStudentId(username);
        System.out.println("查询用户ID借阅的图书："+appointList);//打印查出的图书在控制台
        //3.存数据
        model.addAttribute("appointList", appointList);
        return "books/appoint";
    }
    //用户：归还图书
    @RequestMapping("/reply")
    public String reply(Long id){
        //1.拿到想要还书的用户ID
        System.out.println("想要归还的图书ID：" + id);
        //Student user = (Student) request.getSession().getAttribute("user");//通过session找到用户id
        Book book = bookService.selectByPrimaryKey(id);//通过id拿到归还图书
        System.out.println("想要归还的图书信息：" + book);//打印商品在控制台
        //归还图书
        //2.有该图书，将其删去
        appointService.deleteBybookId(id);//删去借阅的图书
        bookService.addNumberBybookId(id);//增加归还的图书number
        System.out.println("归还成功！");
        return "forward:appoint.do";
        //判断根据用户id的提交的图书id与查询的图书id是否一致
        //if(bookId.equals(appointService.selectByStudentId(user.getStudentId()).getBookId())){
        //throw new AppointException("还书失败");
    }
    @RequestMapping("exit")
    public String exit(HttpServletRequest request) {
        //1.删除session
        request.getSession().removeAttribute("user");
        //2.进入主页面
        return "books/exit";
    }
}
