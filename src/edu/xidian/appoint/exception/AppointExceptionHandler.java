package edu.xidian.appoint.exception;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AppointExceptionHandler implements HandlerExceptionResolver{
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        AppointException appointException=null;//解析异常类型
        // 若该异常类型是系统自定义的异常，直接取出异常信息在错误页面展示即可。
        if(e instanceof AppointException){
            appointException = (AppointException)e;
        }else{
            // 如果不是系统自定义异常，构造一个系统自定义的异常类型，信息为“未知错误”
            appointException = new AppointException("未知错误");
        }
        String message = appointException.getMessage(); //错误信息
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message",message);//将错误信息传到页面
        modelAndView.setViewName("books/err");//指向错误页面
        return modelAndView;
    }

}
