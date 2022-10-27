package com.heima.web.request;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//生命周期
@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {
    private ServletConfig config;

    public void init(ServletConfig servletConfig) throws ServletException {
        config = servletConfig;
        System.out.println();
    }

    public ServletConfig getServletConfig() {
        return config;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("哈哈啥");
        System.out.println(config);
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("销毁");
    }
}
