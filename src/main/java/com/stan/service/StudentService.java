package com.stan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stan.mapper.DormMapper;
import com.stan.mapper.StudentMapper;
import com.stan.mapper.UserMapper;
import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import com.stan.pojo.User;
import com.stan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.*;

public class StudentService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public Student getStudentInfo(String username) {
        SqlSession sqlSession = factory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.selectByUsername(username);

        if (!"STUDENT".equals(user.getRole()))
            return null;

        return studentMapper.selectStudentByNo(user.getUsername());

    }

    public List<Student> selectByDorm(Dorm dorm) {
        SqlSession sqlSession = factory.openSession();
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        List<Student> stuList = stuMapper.selectStudentsByDorm(dorm);
        List<Student> resList = new ArrayList<Student>();

        for (Student stu : stuList) {
            resList.add(stuMapper.selectStudentByNo(stu.getNo()));
        }

        sqlSession.close();
        return resList;
    }

    public Map<String, Object> myDormInfo(String dormId) {
        SqlSession sqlSession = factory.openSession();
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        Dorm dorm = dormMapper.selectDormById(dormId);
        List<Student> students = selectByDorm(dorm);

        Map<String, Object> map = new HashMap<>();

        dorm.setLeader((stuMapper.selectStudentByNo(dorm.getLeader()).getName()));

        map.put("dormInfo", dorm);
        map.put("tableData", students);

        sqlSession.close();
        return map;
    }

    public Dorm nearByDorm(String dorm_id,String dstId){
        SqlSession sqlSession = factory.openSession();
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        Dorm dorm = dormMapper.selectDormById(dorm_id.substring(0, 2) + dstId);
        dorm.setLeader((stuMapper.selectStudentByNo(dorm.getLeader()).getName()));

        return dorm;
    }
}
