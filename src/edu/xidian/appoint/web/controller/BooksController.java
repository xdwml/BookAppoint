package edu.xidian.appoint.web.controller;

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
    //用户：搜索是否有某图书
    @RequestMapping("search")
    public String search(Model model,String name) {
        //查某些图书
        List<Book> booksList=bookService.findSomeBooks(name);
        System.out.println("查询某些图书："+booksList);//打印查出的图书在控制台
        model.addAttribute("booksList",booksList);
        return "books/list";
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

    //管理员：添加图书
    /*@RequestMapping("save")
    public String save(){
        //图书
        Book book=new Book();
        book.setName("计算机网络");
        book.setIntrod("详细剖析，深入解读，完美学习");
        book.setNumber(10L);
        //上架新书
        bookService.insertByBook(book);
        return "forward:list.do";
    }*/
    //管理员：删除图书
    /*@RequestMapping("delete")
    public String delete(Long id){
        //删除数据
        bookService.deleteByPrimaryKey(id);
        return "forward:list.do";//内部转发
    }*/
    //管理员：修改数据
    /*@RequestMapping("edit")
    public String edit(Long id,Model model){
        System.out.println("id"+id);
        //通过id找到商品
        Book book = bookService.selectByPrimaryKey(id);
        System.out.println(book);//打印商品在控制台
        //商品不为空就存储
        if(book !=null){
            model.addAttribute("book",book);
        }
        return "books/edit";
    }*/
    //管理员：更新数据
    /*@RequestMapping("update")
    public String update(Book book,Model model){
        //创建时间不能为空，设置时间
        System.out.println(book);
        bookService.updateByPrimaryKeySelective(book);
        return "forward:list.do";
    }*/

}
