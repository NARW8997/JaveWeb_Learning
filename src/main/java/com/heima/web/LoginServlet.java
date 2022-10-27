package com.heima.web;

import com.heima.mapper.UserMapper;
import com.heima.pojo.User;
import com.heima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 构建sqlsessionfactory
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
        // 获取sqlsession
        SqlSession session = sqlSessionFactory.openSession();

        // 获取mapper
        UserMapper mapper = session.getMapper(UserMapper.class);

        // 执行sql
        User user = mapper.select(username,password);

        // 释放资源
        session.close();
        // 获取输出流
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        // 处理结果
        if (user == null) {
            writer.write("<h1>登录失败</h1>");
        }
        else {
            writer.write("<h1>登录成功</h1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
