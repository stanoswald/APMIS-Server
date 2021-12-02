package com.stan.mapper;

import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    List<Student> selectStudentsByDorm(Dorm dorm);

    Student selectStudentByNo(String no);
}
