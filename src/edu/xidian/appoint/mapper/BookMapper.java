package edu.xidian.appoint.mapper;

import edu.xidian.appoint.model.Book;
import edu.xidian.appoint.model.BookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {

    /**
     * 返回所有图书
     * @return
     */
    public List<Book> findAllBooks();
    //查询某些图书
    public List<Book> findSomeBooks(String name);

    int countByExample(BookExample example);

    int deleteByExample(BookExample example);


    int deleteByPrimaryKey(Long bookId);


    int insert(Book record);


    int insertSelective(Book record);


    List<Book> selectByExample(BookExample example);


    Book selectByPrimaryKey(Long bookId);


    int updateByExampleSelective(@Param("record") Book record, @Param("example") BookExample example);


    int updateByExample(@Param("record") Book record, @Param("example") BookExample example);

    int updateByPrimaryKeySelective(Book record);


    int updateByPrimaryKey(Book record);
}