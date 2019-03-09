package com.hisen.test;

import com.hisen.entity.Book;
import com.hisen.service.BookService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyBatisCacheSecondTest extends BookDaoTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testCache() {
        //查询两次，第二次就直接在redis取出
        List<Book> list = bookService.getList(0, 10);
        System.out.println(list);
        List<Book> list1 = bookService.getList(0, 10);
        System.out.println(list1);
    }
    /**
     * 提醒：在控制台搜索：Cache Hit Ratio 即可看到数据
     */
}
