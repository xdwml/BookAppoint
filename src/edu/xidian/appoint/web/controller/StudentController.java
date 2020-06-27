package edu.xidian.appoint.web.controller;
import edu.xidian.appoint.model.Student;
import edu.xidian.appoint.service.IBookService;
import edu.xidian.appoint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;

@Controller
public class StudentController {
    @Autowired//由spring装入service
    private StudentService studentService;
    //简单校验
    /*@RequestMapping("login")
    public String login(String username, String password, HttpSession session){
        if("wml".equals(username) && "123456".equals(password)){
            //登录成功
            //1.保存session
            session.setAttribute("user",username);
            //2.进入主页面
            return "redirect:books/list.do";
        }
        //登录失败
        return "login";
    }*/
    //获取数据库数据校验
    @RequestMapping("login")
    public String login(Long username, Long password, HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        Student student=studentService.findByID(username);
        if (student==null){
            System.out.println("该用户不存在！");
        }
        long pd=student.getPassword();
        request.setCharacterEncoding("utf-8");
        if(pd==password){
            //登录成功
            //1.保存session
            HttpSession session=request.getSession();
            session.setAttribute("user",student);
            System.out.println("添加cookie用户名:"+username.toString());
            Cookie stu=new Cookie("username",username.toString());
            response.addCookie(stu);

            //2.进入主页面
            return "redirect:books/list.do";
        }
        //登录失败
        return "login";
    }
}