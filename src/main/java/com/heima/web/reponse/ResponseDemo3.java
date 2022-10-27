package com.heima.web.reponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字符数据
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //注意需要先设定
        response.setContentType("text/html;charset=utf-8");
        // 输出流
        PrintWriter writer = response.getWriter();
        // 如果想解析成html，需要设置content type
//        response.setHeader("content-type", "text/html");
        // 上面设置下，中文会乱码。所以需要下面的设置，注意，必须要写在writer之前
//        response.setContentType("text/html;charset=utf-8");
        writer.write("<h1>徐宁伶傻逼</h1>");
        // 该流不用关闭
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
