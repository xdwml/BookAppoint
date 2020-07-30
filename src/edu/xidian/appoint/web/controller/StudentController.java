package edu.xidian.appoint.web.controller;
import edu.xidian.appoint.model.Student;
import edu.xidian.appoint.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class StudentController {
    @Autowired//由spring装入service
    private StudentService studentService;
    @RequestMapping("login")
    public String login(Long username, Long password, Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Student student=studentService.selectByPrimaryKey(username);//从数据库中获取登录用户信息
        if (student!=null && username.equals(student.getStudentId()) &&
            password !=null && password.equals(student.getPassword())){
            request.setCharacterEncoding("utf-8");
            //1.登录成功，将用户对象添加到session
            HttpSession session=request.getSession();
            session.setAttribute("user",student);
            //2.将用户账号添加在cookie请求中
            Cookie stu=new Cookie("username",username.toString());
            response.addCookie(stu);
            //3.重定向到主页面的跳转方法
            return "redirect:books/list.do";
        }
        //4.登录失败
        model.addAttribute("msg","用户名或密码错误，请重新登录！");
        return "login";
    }
}
