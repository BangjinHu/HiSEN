package com.hisen.test;

import com.hisen.mapper.BookMapper;
import com.hisen.entity.Book;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDaoTest extends BaseTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void addBook(){
        for (int i = 0; i < 10; i++){
            Book book = new Book();
            book.setDetail("描述" + i);
            book.setName("火影" + i);
            book.setNumber(i + 10);
            int num = bookMapper.addBook(book);
        }
    }

    @Test
    public void getById(){
        Book book = bookMapper.getById(101);

    }

//    @Test
//    public void getList() {
//        List<Book> books = bookMapper.getList(1, 10);
//        System.out.println(books);
//    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setBookId(101);
        book.setDetail("描述---修改");
        book.setName("活着---修改");
        book.setNumber(100);
        int num = bookMapper.updateBook(book);
    }

    @Test
    public void deleteBookById() {
        bookMapper.deleteBookById(100);
    }
}
