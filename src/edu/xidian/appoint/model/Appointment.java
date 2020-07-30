package edu.xidian.appoint.model;
import java.util.Date;
public class Appointment{
    private Long bookId;
    private Long studentId;
    private Date appointTime;
    //多对一的符合
    private Book book;
    public Appointment(){
    }
    public Appointment(Long bookId,Long studentId,Date appointTime){
        this.bookId=bookId;
        this.studentId=studentId;
        this.appointTime=appointTime;
    }
    public Book getBook(){
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Long getBookId() {
        return bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Date getAppointTime() {
        return appointTime;
    }
    public void setAppointTime(Date appointTime) {
        this.appointTime = appointTime;
    }
    public String toString() {
        return "Appointment{" +
                "bookId=" + bookId +
                ", studentId=" + studentId +
                ", appointTime=" + appointTime +
                ", book=" + book +
                '}';
    }
}