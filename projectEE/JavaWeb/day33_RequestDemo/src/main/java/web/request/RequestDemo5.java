package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 请求转发(forward):一种在服务器内部的资源跳转方式。
 * 浏览器发送请求给服务器，服务器中对应的资源A接收到请求
 * 资源A处理完请求后将请求发给资源B
 * 资源B处理完后将结果响应给浏览器
 * 请求从资源A到资源B的过程就叫请求转发
 *
 * 请求转发资源间共享数据:使用Request对象
 * 此处主要解决的问题是把请求从/req5转发到/req6的时候，如何传递数据给
 * 需要使用request对象提供的三个方法:
 * 存储数据到request域[范围,数据是存储在request对象]中
 * void setAttribute(String name,Object o);
 * 根据key获取值
 * Object getAttribute(String name);
 * 根据key删除该键值对
 * void removeAttribute(String name);
 *
 * 请求转发的特点
 * 浏览器地址栏路径不发生变化
 * 只能转发到当前服务器的内部资源,不能从一个服务器通过转发访问另一台服务器
 * 一次请求，可以在转发资源间使用request共享数据,虽然后台从/req5转发到/req6，但是这个只有一次请求
 */
@WebServlet("/req5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo5...");
        System.out.println(request);
        //存储数据
        request.setAttribute("msg","hello");

        //请求转发
        request.getRequestDispatcher("/req6").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
