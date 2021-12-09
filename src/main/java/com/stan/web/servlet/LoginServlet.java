package com.stan.web.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.stan.pojo.User;
import com.stan.service.UserService;
import com.stan.util.JSONUtil;
import jdk.nashorn.internal.ir.debug.JSONWriter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Map<String, String> map = JSONUtil.paramsToMap(request);

        String username = map.get("username");
        String password = map.get("password");
        String remember = map.get("remember");

        response.setContentType("application/json;charset=utf-8");

        User user = userService.login(username, password);

        if (user != null) {

            if ("remember".equals(remember)) {
                Cookie c_usr = new Cookie("username", username);
                Cookie c_pwd = new Cookie("password", password);

                c_usr.setMaxAge(60 * 60 * 24 * 3);
                c_pwd.setMaxAge(60 * 60 * 24 * 3);

                response.addCookie(c_usr);
                response.addCookie(c_pwd);
            }

            response.getWriter().write(JSON.toJSONString(user));
        } else
            response.getWriter().write("fail");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
