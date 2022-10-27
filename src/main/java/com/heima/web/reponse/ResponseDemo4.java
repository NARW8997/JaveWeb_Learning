package com.heima.web.reponse;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 相应字节数据
 */
@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取文件
        FileInputStream fs = new FileInputStream("F:/demo1.jpg");

        // 获取response字节输出流
        ServletOutputStream outputStream = response.getOutputStream();

//        // 完成流的copy
//        byte[] buff = new byte[1024];
//        int len = 0;
//        while((len = fs.read(buff)) != 1) {
//            outputStream.write(buff, 0 , len);
//        }
//
//        fs.close();

        // 简单用法: 导入common-io依赖包
        IOUtils.copy(fs, outputStream);
        fs.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
