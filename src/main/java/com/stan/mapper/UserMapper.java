package com.stan.mapper;

import com.stan.pojo.User;
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

    @Select("select * from tbl_user where username=#{username}")
    User selectByUsername(String username);

    @Select("select role_name from tbl_role where role_id=" +
            "(select role_id from tbl_user where username=#{username})")
    role selectUserRole(String username);

    @Update("update tbl_user set tel=#{tel}")
    void updateUser(User user);

    @Select("select name from tbl_user where username = #{username}")
    String selectNameByUsername(String username);

    @Select("select tel from tbl_user where username = #{username}")
    String selectTelByUsername(String username);
}
