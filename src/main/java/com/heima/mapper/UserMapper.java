package com.heima.mapper;

import com.heima.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(@Param("username") String username);

    @Insert("INSERT INTO tb_user(id, username, password) values(null, #{username}, #{password})")
    void add(User user);
}
