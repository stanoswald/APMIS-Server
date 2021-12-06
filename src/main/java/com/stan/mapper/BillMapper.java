package com.stan.mapper;

import com.stan.pojo.Bill;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BillMapper {
    @Select("select * from tbl_bill where dorm_id=#{dormId} and bill_date like concat(#{date},'%')")
    List<Bill> selectByDormAndDate(@Param("dormId") String dormId, @Param("date") String date);
}
