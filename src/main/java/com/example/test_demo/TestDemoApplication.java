package com.example.test_demo;

import com.example.test_demo.entity.User;
import com.example.test_demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@MapperScan("com.example.test_demo.mapper")
@SpringBootApplication
public class TestDemoApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(TestDemoApplication.class);

    private final UserService userService;

    public TestDemoApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TestDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("查询开始");
        searchAllInformation();
        //searchByName();
        //searchRelByName();
        log.info("查询结束");
    }

    private void searchAllInformation(){
        User user = new User();
        user.setName("零落");
        List<User> list = userService.searchAll();
        for (User value : list) {
            System.out.println(value);
        }
    }

    private void searchByName(){
        User user = new User();
        user.setName("零落");
        System.out.println(userService.searchByName(user.getName()));
    }

    private void searchRelByName(){
        User user = new User();
        user.setName("零落");
        System.out.println(userService.searchRelationByName(user.getName()).getRelation());
    }
}
