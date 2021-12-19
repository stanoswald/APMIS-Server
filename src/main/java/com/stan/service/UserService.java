package com.stan.service;

import com.stan.mapper.UserMapper;
import com.stan.pojo.User;
import com.stan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public User login(String username, String password) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUsernameAndPassword(username, password);

        sqlSession.close();
        return user;
    }

    public boolean updateUsr(String username, String tel, String email) {
        User user = new User(username, null, null, null, tel, email);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
        return i == 1;
    }

    public boolean updateUsr(String username, String pwd) {
        User user = new User(username, pwd);
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int i = mapper.updateUser(user);

        sqlSession.commit();
        sqlSession.close();
        return i == 1;
    }
}
