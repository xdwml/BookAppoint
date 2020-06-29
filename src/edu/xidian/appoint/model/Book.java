package edu.xidian.appoint.model;

import java.io.Serializable;

public class Book{

    private Long book_id;

    private String name;

    private String introd;


    private Integer number;


    public Long getBookId() {
        return book_id;
    }


    public void setBookId(Long book_id) {
        this.book_id = book_id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getIntrod() {
        return introd;
    }

    public void setIntrod(String introd) {
        this.introd = introd == null ? null : introd.trim();
    }


    public Integer getNumber() {
        return number;
    }


    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + book_id +
                ", name='" + name + '\'' +
                ", introd='" + introd + '\'' +
                ", number=" + number +
                '}';
    }
}