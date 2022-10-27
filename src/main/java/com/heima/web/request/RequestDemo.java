package com.heima.web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

// 通过xml文件配置
@WebServlet("/req1")
public class RequestDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // getMethod() 获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        // String getContextPath() 获取虚拟目录(项目访问路径)：Tomcat-Demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // StringBuffer getRequestURL(): 获取URL：http：//域名+端口号/Tomcat-Demo/req1
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        // String getRequestURI(): 获取URI：没有http，域名和端口号即：Tomcat-Demo/req1
        String uri = req.getRequestURI();
        System.out.println(uri);
        // String getQueryString()：获取请求参数（get方式）：username=zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);

//        --------------------------
        //获取请求头
        String header = req.getHeader("user-agent");
        System.out.println(header);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader br = req.getReader();
        String line = br.readLine();
        System.out.println(line);
    }

}
