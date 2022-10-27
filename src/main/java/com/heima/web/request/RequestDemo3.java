package com.heima.web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/req8")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决乱码 post getReader()输入流编码改变
        request.setCharacterEncoding("UTF-8"); // 设置字符输入流的编码

        // 获取username
        String username = request.getParameter("username");
        System.out.println(username);

        // get，获取参数方式：getQueryString
        // 乱码原因：tomcat进行URL解码，默认的字符集为ISO-8859-1
        // 先对乱码进行转换
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        // 再进行转码
        username = new String(bytes, StandardCharsets.UTF_8);
        System.out.println("解决乱码后: " + username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
