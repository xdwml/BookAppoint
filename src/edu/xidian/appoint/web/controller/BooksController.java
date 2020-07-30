package edu.xidian.appoint.web.controller;

import edu.xidian.appoint.exception.AppointException;
import edu.xidian.appoint.model.Book;
import edu.xidian.appoint.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("books")
public class BooksController {
    @Autowired//由spring装入service
    private BookService bookService;
    //用户：获取图书列表
    @RequestMapping("list")
    public String list(Model model){
        //1.查数据
        List<Book>  booksList=bookService.findAllBooks();
        System.out.println("查询所有图书："+booksList);
        //2.存数据
        model.addAttribute("booksList",booksList);
        return "books/list";
    }
    //用户：搜索图书
    @RequestMapping("search")
    public String search(Model model,String name) {
        //查某些图书
        List<Book> booksList=bookService.findSomeBooks(name);
        //判断查询图书是否存在
        if(booksList.isEmpty()){
            throw new AppointException("馆内没有您要查询的图书");//抛出自定义异常对象
        }else {
            System.out.println("查询某些图书："+booksList);//打印查出的图书在控制台
            model.addAttribute("booksList",booksList);
            return "books/list";
        }
    }
    //用户：图书详情
    @RequestMapping("detail")
    public String detail(Long id,Model model){
        System.out.println("图书ID详情："+id);
        //通过id找到商品
        Book book = bookService.selectByPrimaryKey(id);
        System.out.println("图书ID详情："+book);//打印商品在控制台
        //商品不为空就存储
        if(book !=null){
            model.addAttribute("book",book);
        }
        return "books/detail";
    }
}
