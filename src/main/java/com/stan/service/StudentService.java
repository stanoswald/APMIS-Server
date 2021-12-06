package com.stan.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stan.mapper.*;
import com.stan.pojo.*;
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

    public Dorm nearByDorm(String dorm_id, String dstId) {
        SqlSession sqlSession = factory.openSession();
        DormMapper dormMapper = sqlSession.getMapper(DormMapper.class);
        StudentMapper stuMapper = sqlSession.getMapper(StudentMapper.class);

        Dorm dorm = dormMapper.selectDormById(dorm_id.substring(0, 2) + dstId);
        dorm.setLeader((stuMapper.selectStudentByNo(dorm.getLeader()).getName()));

        sqlSession.close();
        return dorm;
    }

    public boolean repairReg(Repair repair) {
        SqlSession sqlSession = factory.openSession();
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);

        int i = mapper.insertRepair(repair);
        sqlSession.commit();

        sqlSession.close();
        return i == 1;
    }

    public boolean delReg(String id) {
        SqlSession sqlSession = factory.openSession();
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);

        int i = mapper.deleteById(id);
        sqlSession.commit();

        sqlSession.close();
        return i == 1;
    }

    public List<Repair> repairInfo(String no) {
        SqlSession sqlSession = factory.openSession();
        RepairMapper mapper = sqlSession.getMapper(RepairMapper.class);
        PropMapper propMapper = sqlSession.getMapper(PropMapper.class);

        List<Repair> repairList = mapper.selectAll(no);
        for (Repair r : repairList) {
            r.setPropId(propMapper.selectById(r.getPropId()));
        }

        sqlSession.close();
        return repairList;
    }

    public List<Bill> billInfo(String dormId, String month) {
        SqlSession sqlSession = factory.openSession();
        BillMapper mapper = sqlSession.getMapper(BillMapper.class);

        return mapper.selectByDormAndDate(dormId, month);
    }

    public boolean visitorReg(Visitor vis) {
        SqlSession sqlSession = factory.openSession();
        VisitorMapper mapper = sqlSession.getMapper(VisitorMapper.class);

        int i = mapper.insertVisitor(vis);

        sqlSession.commit();

        sqlSession.close();
        return i == 1;
    }

    public List<Visitor> visitorInfo(String reg) {
        SqlSession sqlSession = factory.openSession();
        VisitorMapper mapper = sqlSession.getMapper(VisitorMapper.class);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User u = userMapper.selectByUsername(reg);

        List<Visitor> visitorList = mapper.selectAllByReg(reg);
        for (Visitor v : visitorList) {
            v.setRegistrant(u.getName());
        }

        sqlSession.close();
        return visitorList;
    }

    public boolean delVis(String id) {
        SqlSession sqlSession = factory.openSession();
        VisitorMapper mapper = sqlSession.getMapper(VisitorMapper.class);

        int i = mapper.deleteById(id);
        sqlSession.commit();

        sqlSession.close();
        return i == 1;
    }
}
