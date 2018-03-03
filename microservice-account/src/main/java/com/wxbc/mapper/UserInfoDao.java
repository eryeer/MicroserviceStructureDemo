package com.wxbc.mapper;

import com.wxbc.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserInfoDao {
    @Select("select * from user where name =#{name}")
    UserInfo queryUserWithName(@Param("name") String name);
}
