package com.stan.web.servlet;

import com.alibaba.fastjson.JSON;
import com.stan.pojo.User;
import com.stan.service.UserService;
import com.stan.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet", value = "/update_user")
public class UpdateUserServlet extends HttpServlet {
    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
        String usr = request.getParameter("usr");

        String res = userService.updateUsr(usr, tel, email) ? "success" : "fail";

        response.getWriter().write(res);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> map = JSONUtil.paramsToMap(request);
        String username = map.get("username");
        String currPass = map.get("currPass");
        String pass = map.get("pass");

        String res = "fail";
        User u = userService.login(username, currPass);
        if (u != null) {
            boolean b = userService.updateUsr(username, pass);
            res = b ? "success" : res;
        }

        response.getWriter().write(res);
    }

}
