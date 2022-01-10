package com.example.test_demo.service;

import com.example.test_demo.entity.User;
import com.example.test_demo.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {
    //todo 设置日志
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    //todo 调用接口
    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 查询数据是否存在
     * @param name
     * @return
     */
    public boolean isUserExist(String name){
        if(name == null){
            log.error("输入值为空!");
            return false;
        }
        return userMapper.findByName(name) != null;
    }

    public User searchByName(String name){
        if(!isUserExist(name)){
            log.error("该用户不存在！");
            return null;
        }else {
            if(userMapper.findByName(name) == null){
                log.error("数据库中无此数据项");
                return null;
            }
            return userMapper.findByName(name);
        }
    }

    public User searchRelationByName(String name){
        if (!isUserExist(name)){
            log.error("此用户不存在");
            return null;
        }else{
            if(userMapper.findRelByName(name) == null){
                log.error("数据库中无此数据项");
                return null;
            }else{
                return userMapper.findRelByName(name);
            }
        }
    }

    public List<User> searchAll(){
        if(userMapper.findAll() == null){
            return null;
        }else{
            return userMapper.findAll();
        }
    }

    public boolean insertUser(User user){
        if(user == null){
            log.error("输入内容为空！");
        }

        if(isUserExist(user.getName())){
            log.error("数据库中已经存在该数据！");
            return false;
        }

        int res = userMapper.insertUserInformation(user.getName(), user.getSex(), user.getAge(), user.getAddress(), user.getRelation());

        if(res != 1){
            log.error("插入失败");
            return false;
        }else{
            return true;
        }
    }
}
