package edu.xidian.appoint.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//登录拦截器
public class LoginInterceptor implements HandlerInterceptor{
    // controller执行前调用此方法
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //1.获取请求的url，除了以登录页面结尾的请求url可以放行，其他的URL都进行拦截控制
        if(request.getRequestURI().endsWith("login.do")){
            return true;//放行
        }
        //2.从服务端获取session中，判断session中是否有用户数据，如果有，则放行返回true，继续向下执行
        if(request.getSession().getAttribute("user")!=null){//
            return true;
        }
        //3.不符合条件的给出提示信息，并转发到登录页面（此处转发要写全路径）
        request.setAttribute("msg","您还没有登录，请先登录！");
        //response.sendRedirect("/WEB-INF/views/login.jsp");//客户端，所以用response，重定向，路径改变
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request,response);//服务器，所以用request转发，路径不变
        return false;
    }
    //controller执行后但未返回视图前调用此方法
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }
    //controller执行后且视图返回后调用此方法
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
