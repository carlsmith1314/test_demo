package com.example.test_demo.mapper;

import com.example.test_demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.stereotype.Component;

import javax.persistence.Id;
import java.util.List;

@Mapper
@Component
public interface UserMapper {

    /**
     * 查询test_demo表中所有元素
     * @return
     */
    @Select("select * from test_demo")
    List<User> findAll();

    /**
     * 根据name查询表中信息
     * @param name
     * @return
     */
    @Select("select * from test_demo where name=#{name}")
    User findByName(@Param("name") String name);

    /**
     * 根据name查询relation
     * @param name
     * @return
     */
    @Select("select relation from test_demo where name=#{name}")
    User findRelByName(@Param("name") String name);

    /**
     * 插入信息
     * @param name
     * @param sex
     * @param age
     * @param address
     * @param relation
     * @return
     */
    @Insert("insert into test_demo (name, sex, age, address, relation) " +
            "values (name=#{name}, sex=#{sex}, age=#{age}, address=#{address}, relation=#{relation})")
    int insertUserInformation(@Param("name") String name,
                              @Param("sex") String sex,
                              @Param("age") int age,
                              @Param("address") String address,
                              @Param("relation") String relation);

}
