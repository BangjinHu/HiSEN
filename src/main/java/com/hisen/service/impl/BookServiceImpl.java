package com.hisen.service.impl;

import com.hisen.mapper.BookMapper;
import com.hisen.entity.Book;
import com.hisen.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Book getById(int bookId) {
        return bookMapper.getById(bookId);
    }

    @Override
    public List<Book> getList(int start, int pageNum) {
        return bookMapper.getList(start,pageNum);
    }

    @Override
    public int addBook(Book book) {
        return bookMapper.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    @Override
    public int countNum(){
        return bookMapper.countNum();
    }

    @Override
    public List<Book> getAllPlug() {
        return bookMapper.getAllPlug();
    }
}
