package web.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/*
    response重定向
    HTTP响应数据总共分为三部分内容，分别是响应行、响应头、响应体，
    响应行，比较常用的就是设置响应状态码:void setStatus(int sc)
    设置响应头键值对：void setHeader(String name,String value)
    对于响应体，是通过字符、字节输出流的方式往浏览器写，
    获取字符输出流:PrintWriter getWriter()
    获取字节输出流:ServletOutputStream getOutputStream()

    Response重定向(redirect):一种资源跳转方式。
    (1)浏览器发送请求给服务器，服务器中对应的资源A接收到请求
    (2)资源A现在无法处理该请求，就会给浏览器响应一个302的状态码+location的一个访问资源B的路径
    (3)浏览器接收到响应状态码为302就会重新发送请求到location对应的访问地址去访问资源B
    (4)资源B接收到请求后进行处理并最终给浏览器响应结果，这整个过程就叫重定向

    重定向的特点
    浏览器地址栏路径发送变化
        当进行重定向访问的时候，由于是由浏览器发送的两次请求，所以地址会发生变化
    可以重定向到任何位置的资源(服务内容、外部均可)
        因为第一次响应结果中包含了浏览器下次要跳转的路径，所以这个路径是可以任意位置资源。
    两次请求，不能在多个资源使用request共享数据
        因为浏览器发送了两次请求，是两个不同的request对象，就无法通过request对象进行共享数据

    转发的时候路径上没有加/day33_RequestDemo而重定向加了，那么到底什么时候需要加，什么时候不需要加呢?
    其实判断的依据很简单，只需要记住下面的规则即可:
    浏览器使用:需要加虚拟目录(项目访问路径)
    服务端使用:不需要加虚拟目录
    对于转发来说，因为是在服务端进行的，所以不需要加虚拟目录
    对于重定向来说，路径最终是由浏览器来发送请求，就需要添加虚拟目录。
    1.超链接，从浏览器发送，需要加
    2.表单，从浏览器发送，需要加
    3.转发，是从服务器内部跳转，不需要加
    4.重定向，是由浏览器进行跳转，需要加。

    在重定向的代码中，
    /day33_Request是固定编码的，如果后期通过Tomcat插件配置了项目的访问路径，那么所有需要重定向的地方都需要重新修改，该如何优化？
    我们可以在代码中动态去获取项目访问的虚拟目录，具体如何获取，我们可以借助前面咱们所学习的request对象中的getContextPath()方法
*/

@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("resp1....");

        //重定向
        /*//1.设置响应状态码 302
        response.setStatus(302);
        //2. 设置响应头 Location
        response.setHeader("Location","/request-demo/resp2");*/

        //简化方式完成重定向
        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println(contextPath);    ///day33_RequestDemo
        response.sendRedirect(contextPath+"/resp2");
        //response.sendRedirect("https://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
