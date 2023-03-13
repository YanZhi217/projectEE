package web;

import pojo.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private final UserService service = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取用户名和密码数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //获取用户输入的验证码
        String checkCode = request.getParameter("checkCode");

        //从session获取程序生成的验证码
        HttpSession session = request.getSession();
        String checkCodeGen = (String)session.getAttribute("checkCodeGen");

        //验证验证码
        if(!checkCodeGen.equalsIgnoreCase(checkCode)){
            //不允许注册
            request.setAttribute("register_msg","验证码错误");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
            return ;
        }

        //调用service注册
        Boolean flag = service.register(user);
        //判断成功与否
        if(flag){
            //注册功能，跳转登陆页面
            request.setAttribute("register_msg","注册成功，请登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else{
            //注册失败
            request.setAttribute("register_msg","用户名已存在");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
