package edu.xidian.appoint.service.impl;

import edu.xidian.appoint.mapper.BookMapper;
import edu.xidian.appoint.model.Book;
import edu.xidian.appoint.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;//自动注入dao,mapper就是dao
    @Override
    public List<Book> findAllBooks() {
        return bookMapper.findAllBooks();
    }
    @Override
    public List<Book> findSomeBooks(String name) {
        return bookMapper.findSomeBooks(name);
    }

    @Override
    public int reduceNumberBybookId(long bookId) {
        return bookMapper.reduceNumberBybookId(bookId);
    }

    @Override
    public int addNumberBybookId(long bookId) {
        return bookMapper.addNumberBybookId(bookId);
    }

    @Override
    public Book selectByPrimaryKey(Long bookId) {
        return bookMapper.selectByPrimaryKey(bookId);
    }

    @Override
    public int deleteByPrimaryKey(Long bookId) {
        return bookMapper.deleteByPrimaryKey(bookId);
    }

    @Override
    public int insertByBook(Book book) {
        return bookMapper.insertByBook(book);
    }

    @Override
    public int updateByPrimaryKeySelective(Book book) {
        return bookMapper.updateByPrimaryKeySelective(book);
    }

}
