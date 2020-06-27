package edu.xidian.appoint.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//测试用例
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("list")
    public String list(){
        return "user/list";
    }
}
