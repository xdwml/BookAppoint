package edu.xidian.appoint.service.impl;

import edu.xidian.appoint.mapper.AppointmentMapper;
import edu.xidian.appoint.mapper.BookMapper;
import edu.xidian.appoint.mapper.StudentMapper;
import edu.xidian.appoint.model.Appointment;
import edu.xidian.appoint.model.Book;
import edu.xidian.appoint.model.Student;
import edu.xidian.appoint.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.dc.pr.PRError;

import java.util.List;
@Service
@Transactional
public class BookServiceImpl implements IBookService {
    @Autowired
    private BookMapper bookMapper;//自动注入dao,mapper就是dao
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private AppointmentMapper appointmentMapper;

    @Override
    public List<Book> findAllBooks() {
        //System.out.println(bookMapper);
        return bookMapper.findAllBooks();
    }

    @Override
    public List<Book> findSomeBooks(String name) {
        return bookMapper.findSomeBooks(name);
    }


    @Override
    public Book findByID(Long id) {
        return bookMapper.selectByPrimaryKey(id);
    }



    @Override
    public void saveOrUpdate(Book book) {
        //bookMapper.insert(book);
        if (book.getBookId()==null){
            bookMapper.insert(book);
        }else{
            bookMapper.updateByPrimaryKeySelective(book);
        }
    }

    @Override
    public void deleteByID(Long id) {
        bookMapper.deleteByPrimaryKey(id);
    }
}
