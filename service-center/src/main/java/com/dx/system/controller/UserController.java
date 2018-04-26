package com.dx.system.controller;

import com.dx.system.domain.MicroSort;
import com.dx.system.domain.User;
import com.dx.system.mapper.MicroSortMapper;
import com.dx.system.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by xiewx on 2018/4/19.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private MicroSortMapper microSortMapper;
    @Autowired
    private UserMapper userMapper;

    @ApiOperation(value = "测试",notes = "测试")
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    @ResponseBody
    public int  test(@RequestBody User user){
        //int result=microSortMapper.insert(microSort.getId(),microSort.getName(),microSort.getEnable(),microSort.getParentId(),microSort.getCreateTime());
        user.setId(UUID.randomUUID().toString());
        int result=userMapper.insert(user.getId(),user.getName(),user.getPassword(),user.getPassword());
        return result;
    }
    @ApiOperation(value = "测试",notes = "测试")
    @RequestMapping(value = "/findUserById",method = RequestMethod.POST)
    @ResponseBody
    public User  findUserById(User user1){
        System.out.println(user1);
        User user=userMapper.findUserById(user1.getId());
        System.out.println(" System.out.println(user);");
        System.out.println(user);
        return user;
    }

    @ApiOperation(value = "全查",notes = "全查")
    @RequestMapping(value = "/findAll",method = RequestMethod.POST)
    @ResponseBody
    public List findAll(){
        //int result=microSortMapper.insert(microSort.getId(),microSort.getName(),microSort.getEnable(),microSort.getParentId(),microSort.getCreateTime());
        //int result=userMapper.insert(user.getId(),user.getName(),user.getPassword(),user.getPassword());
        List<User> user=userMapper.findAll();
        System.out.println(" System.out.println(user);");
        System.out.println(user);
        return user;
    }

    @ApiOperation(value = "名字",notes = "名字")
    @RequestMapping(value = "/findName",method = RequestMethod.POST)
    @ResponseBody
    public List findUserByName(User user1){
        //int result=microSortMapper.insert(microSort.getId(),microSort.getName(),microSort.getEnable(),microSort.getParentId(),microSort.getCreateTime());
        //int result=userMapper.insert(user.getId(),user.getName(),user.getPassword(),user.getPassword());
        List<User> user=userMapper.findUserByName(user1.getName());
        System.out.println(" System.out.println(名字);");
        System.out.println(user);
        return user;
    }


}
