package com.stan.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.stan.pojo.Dorm;
import com.stan.pojo.PropReg;
import com.stan.pojo.Student;
import com.stan.pojo.Visitor;
import com.stan.service.DormService;
import com.stan.service.StudentService;
import com.stan.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "PropertyRegServlet",value = "/prop_reg")
public class PropertyRegServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final DormService dormService = new DormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        Map<String, String> map = JSONUtil.paramsToMap(request);

        PropReg propReg = new PropReg(
                null
                , map.get("dormId")
                , map.get("propId")
                , map.get("reg")
                , map.get("type")
                , map.get("stat"));

        String res = studentService.propReg(propReg) ? "success" : "fail";

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
