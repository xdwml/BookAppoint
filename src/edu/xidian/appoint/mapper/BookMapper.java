package edu.xidian.appoint.mapper;

import edu.xidian.appoint.model.Book;

import java.util.List;

public interface BookMapper {
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
    int deleteByPrimaryKey(Long bookId);
    int insertByBook(Book record);

    int updateByPrimaryKeySelective(Book record);

}