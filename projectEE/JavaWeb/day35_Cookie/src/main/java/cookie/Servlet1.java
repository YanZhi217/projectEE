package cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //发送cookie
        //解决中文乱码
        String value = "张三";
        //URL编码
        value = URLEncoder.encode(value, StandardCharsets.UTF_8);
        System.out.println("存储数据为：" + value);
        //创建cookie对象,键，值
        Cookie cookie = new Cookie("username",value);
        //设置存活时间，一周七天
        cookie.setMaxAge(60*60*24*7);
        //发送cookie，response
        response.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
