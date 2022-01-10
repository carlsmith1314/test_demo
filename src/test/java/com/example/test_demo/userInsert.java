package com.example.test_demo;

import com.example.test_demo.entity.User;
import com.example.test_demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
//todo 事务管理
@Transactional
//todo 运行控制
@RunWith(SpringRunner.class)
//todo 测试控制
@SpringBootTest
public class userInsert {
    @Autowired
    private UserService userService;

    @Test //todo 标记测试的部分
    public void TestArticleMapper() {
        //todo 自定义插入数据
        User user = new User();
        user.setName("张三");
        user.setSex("男");
        user.setAge(23);
        user.setAddress("上海市");
        user.setRelation("同学");
        userService.insertUser(user);
        userService.searchByName("张三");
    }
}