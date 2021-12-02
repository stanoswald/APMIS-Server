package com.stan.service;

import com.stan.mapper.DormMapper;
import com.stan.mapper.StudentMapper;
import com.stan.mapper.UserMapper;
import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import com.stan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Student selectByNo(String no) {
        SqlSession sqlSession = factory.openSession();
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        Student stu = stuMapper.selectStudentByNo(no);

        stu.setTel(userMapper.selectTelByUsername(no));
        stu.setName(userMapper.selectNameByUsername(no));

        sqlSession.close();
        return stu;
    }

    public List<Student> selectByDorm(Dorm dorm) {
        SqlSession sqlSession = factory.openSession();
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> stuList = stuMapper.selectStudentsByDorm(dorm);
        List<Student> resList = new ArrayList<Student>();

        for (Student stu : stuList) {
            resList.add(selectByNo(stu.getNo()));
        }

        sqlSession.close();
        return resList;
    }

    public Map<String,Object> myDormInfo(String dormId){
        SqlSession sqlSession = factory.openSession();
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);

        Dorm dorm = dormMapper.selectDormById(dormId);
        List<Student> students = selectByDorm(dorm);

        Map<String, Object> map = new HashMap<>();

        dorm.setLeaderNo(selectByNo(dorm.getLeaderNo()).getName());

        map.put("dormInfo", dorm);
        map.put("member", students);

        return map;
    }
}
