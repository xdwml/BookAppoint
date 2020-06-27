package edu.xidian.appoint.service;

import edu.xidian.appoint.model.Book;
import java.util.List;
public interface IBookService {

    /**
     * 查询一本图书
     * @param id
     * @return
     */
    public Book findByID(Long id);

    /**
     * 查询所有图书
     * @return
     */
    public List<Book> findAllBooks();
    /**
     * 按条件查询图书，按图书名字查询
     * @return
     */
    public List<Book> findSomeBooks(String name);

    public void saveOrUpdate(Book book);
    public void deleteByID(Long id);
}
