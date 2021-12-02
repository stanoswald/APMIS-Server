package com.stan.test;

import com.stan.mapper.DormMapper;
import com.stan.mapper.StudentMapper;
import com.stan.mapper.UserMapper;
import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import com.stan.pojo.User;
import com.stan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class DAOTest {
    private final SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = mapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSelectByUsername() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.selectByUsername("211906426");
        System.out.println(user);
    }

    @Test
    public void testSelectUserRole() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        UserMapper.role role = mapper.selectUserRole("211906351");
        System.out.println(role);
    }

    @Test
    public void testSelectStudentByNo(){
        SqlSession sqlSession = factory.openSession();
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = stuMapper.selectStudentByNo("211906426");
        System.out.println(student);
    }

    @Test
    public void testSelectDormById(){
        SqlSession sqlSession = factory.openSession();
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);

        Dorm dorm = dormMapper.selectDormById("18615");
        System.out.println(dorm);
    }

    @Test
    public void testSelectStuByDorm() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);

        List<Student> stuList = stuMapper.selectStudentsByDorm(
                dormMapper.selectDormById("18615")
        );

        for (Student stu : stuList) {
            System.out.println(stu);
        }
    }
}
