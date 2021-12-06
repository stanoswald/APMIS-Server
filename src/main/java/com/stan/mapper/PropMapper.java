package com.stan.mapper;

import com.stan.pojo.PropReg;
import com.stan.pojo.Property;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PropMapper {
    @Select("SELECT * FROM tbl_prop")
    List<Property> selectAllProperty();

    @Select("SELECT DISTINCT name FROM tbl_prop")
    List<String> selectAllType();

    @Select("SELECT concat_ws('-',`name`,model) FROM `tbl_prop` WHERE prop_id=#{id}")
    String selectById(String id);

    @Insert("insert into tbl_prop_reg values(null,#{dormId},#{propId},#{registrant},#{regType},#{stat})")
    int insertPropReg(PropReg reg);

    @Select("SELECT * from tbl_prop_reg where registrant=#{no}")
    List<PropReg> selectAllPropRegByNo(String no);

    @Delete("delete from tbl_prop_reg where prop_reg_id=#{id}")
    int deleteRegById(String id);
}
