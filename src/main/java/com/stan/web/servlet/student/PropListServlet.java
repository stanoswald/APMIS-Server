package com.stan.web.servlet.student;

import com.alibaba.fastjson.JSON;
import com.stan.service.PropService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PropListServlet", value = "/get_prop")
public class PropListServlet extends HttpServlet {
    private final PropService propService = new PropService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");


        Map<String, Object> map = new HashMap<>();
        map.put("type", propService.getAllType());
        map.put("allProp", propService.getAllProp());


        response.getWriter().write(JSON.toJSONString(map));


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
