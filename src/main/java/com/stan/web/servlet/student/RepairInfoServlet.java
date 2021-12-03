package com.stan.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.stan.pojo.Dorm;
import com.stan.pojo.Student;
import com.stan.service.DormService;
import com.stan.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/repairInfoServlet")
public class RepairInfoServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final DormService dormService = new DormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("dorm selecting");
        String dormId = request.getParameter("dorm_id");
        Dorm dorm = dormService.selectById(dormId);
        List<Student> students = studentService.selectByDorm(dorm);
        Map<String, Object> map = new HashMap<>();


        map.put("dormInfo", dorm);
        map.put("member", students);

        String jsonStr = JSON.toJSONString(map);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
