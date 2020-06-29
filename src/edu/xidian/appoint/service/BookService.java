package edu.xidian.appoint.service;

import edu.xidian.appoint.model.Book;
import java.util.List;
public interface BookService {

    //查询所有图书
    List<Book> findAllBooks();
    //查询某些图书
    List<Book> findSomeBooks(String name);
    //减小图书库存
    int reduceNumberBybookId(long bookId);
    //增加图书库存
    int addNumberBybookId(long bookId);
    //查询一本图书
    Book selectByPrimaryKey(Long bookId);
    //删除图书
    int deleteByPrimaryKey(Long bookId);
    //插入图书
    int insertByBook(Book book);
    //更新图书
    int updateByPrimaryKeySelective(Book book);

}
