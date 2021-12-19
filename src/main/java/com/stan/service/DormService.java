package com.stan.service;

import com.stan.mapper.DormMapper;
import com.stan.pojo.Dorm;
import com.stan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class DormService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Dorm selectById(String id) {
        SqlSession sqlSession = factory.openSession();
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);

        Dorm dorm = dormMapper.selectDormById(id);

        sqlSession.close();
        return dorm;
    }


}
