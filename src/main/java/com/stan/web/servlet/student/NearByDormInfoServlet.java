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

@WebServlet(name = "NearByDormInfoServlet", value = "/near_dorm")
public class NearByDormInfoServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final DormService dormService = new DormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dormId = request.getParameter("dorm_id");
        String dstId = request.getParameter("dstId");

        Dorm dorm = studentService.nearByDorm(dormId, dstId);

        if (dorm != null) {
            String jsonStr = JSON.toJSONString(dorm);

            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonStr);
        }
        else response.getWriter().write("empty result");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
