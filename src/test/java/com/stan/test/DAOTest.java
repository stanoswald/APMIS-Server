package com.stan.test;

import com.stan.mapper.*;
import com.stan.pojo.*;
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
    public void testUserSelect() {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User u1 = mapper.selectByUsername("211906426");
        System.out.println(u1);

        User u2 = mapper.selectByUsernameAndPassword("211906351", "abcyjw");
        System.out.println(u2);
    }

    @Test
    public void testSelectStudentByNo() {
        SqlSession sqlSession = factory.openSession();
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        Student student = stuMapper.selectStudentByNo("211906426");
        System.out.println(student);
    }

    @Test
    public void testSelectDormById() {
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

    @Test
    public void testRepair() {
        SqlSession sqlSession = factory.openSession();
        PropMapper mapper = sqlSession.getMapper(PropMapper.class);

        for (Property property : mapper.selectAllProperty()) {
            System.out.println(property);
        }

        RepairMapper repairMapper = sqlSession.getMapper(RepairMapper.class);
        for (Repair r : repairMapper.selectAll("211906426")) {
            System.out.println(r);
        }

        System.out.println(mapper.selectById("1"));
    }

    @Test
    public void testBill() {
        SqlSession sqlSession = factory.openSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        for (Bill bill : mapper.selectByDormAndDate("18615", "2021-11")) {
            System.out.println(bill);
        }

    }

    @Test
    public void testPropReg() {
        SqlSession sqlSession = factory.openSession();
        PropMapper mapper = sqlSession.getMapper(PropMapper.class);

        int i = mapper.insertPropReg(
                new PropReg(null,
                        "18615",
                        "4",
                        "211906426",
                        "移入",
                        "待审核"));

        sqlSession.commit();
        sqlSession.close();
        System.out.println(i);
    }
}
