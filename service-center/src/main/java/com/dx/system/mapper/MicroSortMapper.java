package com.dx.system.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * Created by xiewx on 2018/4/19.
 */
@Mapper
public interface MicroSortMapper {

    @Insert("INSERT INTO SYS_MICRO_SORT(ID, NAME, ENABLE,PARENT_ID,CREATE_TIME) VALUES(#{id}, #{name}, #{enable}, #{parentId}, #{createTime})")
    int insert(@Param("id") String id, @Param("name") String name, @Param("enable") String enable, @Param("parentId") String parentId, @Param("createTime") Date createTime);
}
