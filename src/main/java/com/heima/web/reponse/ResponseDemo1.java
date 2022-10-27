package com.heima.web.reponse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1");
        //重定向
        response.setStatus(302);
        // 动态获得虚拟路径
        String path = request.getContextPath();
        response.setHeader("location", path + "/resp2");
//
        //简单做法
//        response.sendRedirect("Http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
