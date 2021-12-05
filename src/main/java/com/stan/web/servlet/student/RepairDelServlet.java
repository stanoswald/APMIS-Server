package com.stan.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.stan.pojo.Repair;
import com.stan.service.DormService;
import com.stan.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RepairDelServlet", value = "/repair_del")
public class RepairDelServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final DormService dormService = new DormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        boolean i = studentService.delReg(id);

        String res = i ? "success" : "fail";

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
