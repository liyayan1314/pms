package com.dx.system.mapper;

import com.dx.system.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by xiewx on 2018/4/18.
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USER WHERE ID = #{id}")
    public User findUserById(@Param("id") String id);

    /*@Insert("INSERT INTO USER(NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);*/

    @Insert("INSERT INTO USER(ID,NAME, PASSWORD, PHONE) VALUES(#{id},#{name}, #{password}, #{phone})")
    int insert(@Param("id") String id,@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

    @Select("SELECT * FROM USER")
    public List<User> findAll();

    @Select("select * from user where name=#{name}")
    public List<User> findUserByName(@Param("name") String name);
}
