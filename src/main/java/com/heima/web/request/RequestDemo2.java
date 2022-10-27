package com.heima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;

// 通过xml文件配置
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // get
        String method = req.getMethod();
        System.out.println(method + "............");

        // 1. 获取所有参数的map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.print(key + ":");
            String[] strings = parameterMap.get(key);
            for (String s : strings) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------------------------");
        // 2. 根据key获取参数值，数组
        String[] strs = req.getParameterValues("whoIsSb");
        for (String s : strs) {
            System.out.println(s);

        }

        System.out.println("----------------");
        // 3. 根据key获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
