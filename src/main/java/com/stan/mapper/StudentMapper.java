package com.stan.mapper;

import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from tbl_stu where dorm_id=#{dormId}")
    List<Student> selectStudentsByDorm(Dorm dorm);

    @Select("select * from tbl_stu where stu_no=#{no}")
    Student selectStudentByNo(String no);
}
