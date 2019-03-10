package com.hisen.mapper;

import com.hisen.entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper {
    Book getById(int bookId);

    List<Book> getList(@Param("offset") int start, @Param("limit") int pageNum);

    int addBook(Book book);

    int updateBook(Book book);

    int deleteBookById(int id);

    int countNum();

    List<Book> getAllPlug();
}
