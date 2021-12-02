package com.stan.mapper;

import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import org.apache.ibatis.annotations.Select;

public interface DormMapper {
    @Select("select * from tbl_dorm where dorm_id " +
            "= (select dorm_id from tbl_stu where stu_no=#{no})")
    Dorm selectDormByStu(Student stu);

    @Select("select * from tbl_dorm where dorm_id=#{id}")
    Dorm selectDormById(String id);
}
