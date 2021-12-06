package com.stan.web.servlet.student;

import com.stan.service.DormService;
import com.stan.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PropertyRegDelServlet", value = "/prop_reg_del")
public class PropertyRegDelServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        boolean i = studentService.delPropReg(id);

        String res = i ? "success" : "fail";

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
