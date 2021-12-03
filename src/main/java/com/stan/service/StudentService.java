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

    public Dorm nearByDormInfo(String myDormId, String dormId) {
        SqlSession sqlSession = factory.openSession();
        DormMapper mapper = sqlSession.getMapper(DormMapper.class);

        if (myDormId.substring(0, 2).equals(dormId.substring(0, 2)))
            return mapper.selectDormById(dormId);

        sqlSession.close();
        return null;
    }
}
