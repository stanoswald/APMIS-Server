package com.stan.mapper;

import com.stan.pojo.Property;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PropMapper {
    @Select("SELECT * FROM tbl_prop")
    List<Property> selectAllProperty();

    @Select("SELECT DISTINCT name FROM tbl_prop")
    List<String> selectAllType();

    @Select("SELECT concat_ws('-',`name`,model) FROM `tbl_prop` WHERE prop_id=#{id}")
    String selectById(String id);
}
