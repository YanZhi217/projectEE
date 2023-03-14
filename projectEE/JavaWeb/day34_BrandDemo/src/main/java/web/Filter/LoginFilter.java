package web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/*
    登陆验证的过滤器
*/
@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        //判断访问资源路径是否和登陆注册有关
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","register.jsp","registerServlet","/checkCodeServlet"};
        //获取当前访问的资源路径
        String url = req.getRequestURL().toString();
        //循环判断
        for (String s : urls) {
            if(url.contains(s)){
                //找到了
                //放行
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }


        //判断session中是否有user对象
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        //判断user是否为null
        if(user != null){
            //已经登陆
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //没有登陆
            //存储提示信息,跳转到登录页面
            req.setAttribute("login_msg","您尚未登陆");
            req.getRequestDispatcher("/login.jsp").forward(req,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
