package com.stan.mapper;

import com.stan.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {

    enum role {
        UNDEFINED,
        MANAGER,
        STUDENT,
        PLUMBER,
        ADMIN,
    }

    @Select("select * from tbl_user")
    List<User> selectAll();

    User selectByUsername(String username);

    User selectByUsernameAndPassword(@Param("usr") String username, @Param("pwd") String password);
}
