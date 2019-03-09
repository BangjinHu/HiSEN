package com.hisen.test;

import com.hisen.entity.User;
import com.hisen.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试添加用户
     */
    @Test
    public void insert(){
        User u = new User();
        u.setUserName("阿星");
        u.setUserAddress("北京市朝阳区");
        u.setUserPhone("13820080001");
        u.setUserNumber("20080001");
        int insert = userMapper.insert(u);
        System.out.println(insert);
    }
}
