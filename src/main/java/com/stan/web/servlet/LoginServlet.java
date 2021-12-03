package com.stan.web.servlet;

import com.stan.pojo.User;
import com.stan.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/loginServlet")
public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        User user = userService.login(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            if ("remember".equals(remember)) {
                Cookie c_usr = new Cookie("username", username);
                Cookie c_pwd = new Cookie("username", password);

                c_usr.setMaxAge(60 * 60 * 24 * 3);
                c_pwd.setMaxAge(60 * 60 * 24 * 3);

                response.addCookie(c_usr);
                response.addCookie(c_pwd);
            }

            String contextPath = request.getContextPath();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
