package com.stan.service;

import com.stan.mapper.PropMapper;
import com.stan.pojo.Property;
import com.stan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //空调=[{5=m-100}, {6=KF-23G}]
    public Map<String, ArrayList<Map<String, String>>> getPropList() {
        SqlSession sqlSession = factory.openSession();
        PropMapper mapper = sqlSession.getMapper(PropMapper.class);

        Map<String, ArrayList<Map<String, String>>> res = new HashMap<>();

        for (Property p : mapper.selectAllProperty()) {
            Map<String, String> m = new HashMap<>();
            m.put(p.getId(), p.getModel());

            if (res.get(p.getName()) == null) {
                ArrayList<Map<String, String>> arr = new ArrayList<>();
                res.put(p.getName(), arr);
            }
            res.get(p.getName()).add(m);
        }
        return res;
    }

    public List<Property> getAllProp() {
        SqlSession sqlSession = factory.openSession();
        PropMapper mapper = sqlSession.getMapper(PropMapper.class);

        return mapper.selectAllProperty();
    }

    public List<String> getAllType() {
        SqlSession sqlSession = factory.openSession();
        PropMapper mapper = sqlSession.getMapper(PropMapper.class);

        return mapper.selectAllType();
    }
}
