package com.stan.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.stan.service.DormService;
import com.stan.service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MyDormInfoServlet", value = "/my_dorm")
public class MyDormInfoServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final DormService dormService = new DormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String dormId = request.getParameter("dorm_id");

        String jsonStr = JSON.toJSONString(studentService.myDormInfo(dormId));

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
