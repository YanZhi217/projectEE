package web;

import pojo.User;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private final UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //获取复选框数据
        String remember = request.getParameter("remember");
        //调用service查询
        User user = service.login(username,password);
        if(user != null){
            //判断用户是都勾选记住我
            if("1".equals(remember)){
                //勾选了,发送Cookie
                //创建Cookie对象
                Cookie cUsername = new Cookie("username",username);
                Cookie cPassword = new Cookie("password",password);
                //设置cookie存活时间
                cUsername.setMaxAge(60*60*24*7);
                cPassword.setMaxAge(60*60*24*7);
                //发送Cookie
                response.addCookie(cUsername);
                response.addCookie(cPassword);
            }
            //将登录成功后的user对象存储到Session中
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            //登陆成功,重定向跳转到查询所有的BrandServlet
            String contextPath = request.getContextPath();
            //response.sendRedirect(contextPath + "/SelectAllServlet");
            response.sendRedirect(contextPath + "/brand.html");

        }else{
            //登陆失败
            //存储错误信息到request
            request.setAttribute("login_msg","用户名或密码错误");
            //跳转到login.jsp
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
