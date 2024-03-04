package com.example.libraryManagementSystem.entity;

import jakarta.persistence.*;

import java.util.Date;




@Entity
public class TransactionEntity {
    @Id  //making primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private long transaction_id;

    @Column(name = "member_id")
    private long member_id;

    @Column(name = "book_id")
    private long book_id;

    @Column(name = "borrow_date")
    private Date borrow_date;

    @Column(name = "expected_return")
    private Date expected_return;

    @Column(name = "actual_return")
    private Date actual_return;

    @Column(name = "book_title")
    private String book_title;

    @Column(name = "isbn")
    private String isbn;

    public TransactionEntity() {
        // Initialize any default values if needed
        this.transaction_id = 0;
        this.member_id = 0;
        this.book_id = 0;
        this.borrow_date = null;
        this.expected_return = null;
        this.actual_return = null;
        this.book_title = null;
        this.isbn = null;
    }
    public TransactionEntity(long transaction_id, long member_id, long book_id, Date borrow_date, Date expected_return, Date actual_return, String book_title, String isbn) {
        this.transaction_id = transaction_id;
        this.member_id = member_id;
        this.book_id = book_id;
        this.borrow_date = borrow_date;
        this.expected_return = expected_return;
        this.actual_return = actual_return;
        this.book_title = book_title;
        this.isbn = isbn;
    }

    public long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }

    public long getMember_id() {
        return member_id;
    }

    public void setMember_id(long member_id) {
        this.member_id = member_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public Date getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(Date borrow_date) {
        this.borrow_date = borrow_date;
    }

    public Date getExpected_return() {
        return expected_return;
    }

    public void setExpected_return(Date expected_return) {
        this.expected_return = expected_return;
    }

    public Date getActual_return() {
        return actual_return;
    }

    public void setActual_return(Date actual_return) {
        this.actual_return = actual_return;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString(){
        return " [transaction_id=" + transaction_id + ", member_id=" + member_id + ", book_id=" + book_id + ", borrow_date" + borrow_date + ", expected_return" + expected_return + ", actual_return" + actual_return + ", book_title"  + book_title + ", isbn" + isbn + "]";
    }

}
