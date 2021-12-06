package com.stan.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.stan.pojo.PropReg;
import com.stan.pojo.Visitor;
import com.stan.service.DormService;
import com.stan.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PropertyRegInfoServlet", value = "/prop_reg_info")
public class PropertyRegInfoServlet extends HttpServlet {
    private final StudentService studentService = new StudentService();
    private final DormService dormService = new DormService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String reg = request.getParameter("reg");

        List<PropReg> propRegs = studentService.propRegInfo(reg);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JSON.toJSONString(propRegs));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
