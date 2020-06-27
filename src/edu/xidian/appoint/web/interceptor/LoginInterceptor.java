package edu.xidian.appoint.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //拦截
        //1.排除不需要拦截路径
        System.out.println("客户端访问资源的路径："+request.getRequestURI());
        if(request.getRequestURI().endsWith("login.do")){
            return true;//放行
        }
        //2.如果已经登录，也要放行
        if(request.getSession().getAttribute("user")!=null){//从服务端的session中获取用户
            return true;
        }
        //3.进入到登录页面//写全路径
        //response.sendRedirect("/WEB-INF/views/login.jsp");//客户端，所以用response，重定向，路径改变
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);//服务器，所以用request转发，路径不变
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
