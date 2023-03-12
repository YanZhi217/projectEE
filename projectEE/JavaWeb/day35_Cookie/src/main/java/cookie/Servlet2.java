package cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取Cookie
        //获取Cookie数组
        Cookie[] cookies = request.getCookies();
        //遍历Cookie数组
        for (Cookie cookie : cookies) {
            //获取数据
            String name = cookie.getName();
            if("username".equals(name)) {
                String value = cookie.getValue();
                //URL解码
                value = URLDecoder.decode(value, StandardCharsets.UTF_8);
                System.out.println(name + ":" + value);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
