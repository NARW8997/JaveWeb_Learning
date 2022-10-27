package com.heima.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = {"/demo3", "/demo3_1"})  精准匹配
//@WebServlet(urlPatterns = "/user/*") 目录匹配 当同时满组精准匹配和目录匹配时，则精准匹配优先
//@WebServlet(urlPatterns = "/user/*.do") 拓展名匹配
//@WebServlet(urlPatterns = "/ 或者 /*") 任意匹配。 / 会覆盖tomcat中DefaultServlet，当其他的pattern
// 匹配不上时，会走这个 （很少用到）
// 优先级：精准 > 目录 > 拓展名 > 任意匹配
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("get method lunched");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post method lunched");
    }
}
