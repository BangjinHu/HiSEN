package com.hisen.service;

import com.hisen.entity.Book;

import java.util.List;

public interface BookService {
    Book getById(int bookId);

    List<Book> getList(int start, int pageNum);

    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(int id);

    int countNum();

    List<Book> getAllPlug();
}
