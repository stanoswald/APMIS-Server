package com.stan.mapper;

import com.stan.pojo.Visitor;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VisitorMapper {
    @Insert("insert into tbl_visit values(null,#{name},#{detail},#{registrant},#{startTime},#{endTime},#{stat})")
    int insertVisitor(Visitor visitor);

    @Select("select * from tbl_visit where registrant=#{reg}")
    List<Visitor> selectAllByReg(String reg);

    @Delete("delete from tbl_visit where visit_id=#{id}")
    int deleteById(String id);
}
