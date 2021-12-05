package com.stan.mapper;

import com.stan.pojo.Property;
import com.stan.pojo.Repair;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RepairMapper {
    @Insert("insert into tbl_repair values (null,#{dormId},#{registrant},#{propId},#{detail},null)")
    int insertRepair(Repair repair);

    @Select("select * from tbl_repair where registrant=#{username}")
    List<Repair> selectAll(String username);

    @Delete("DELETE from tbl_repair where repair_id=#{id}")
    int deleteById(String id);
}
