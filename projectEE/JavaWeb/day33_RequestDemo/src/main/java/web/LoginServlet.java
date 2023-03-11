package web;

import mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //调取Mybatis完成查询
        //获取SqlSessionFactory对象
        /*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*/
        SqlSessionFactory sqlSessionFactory = utils.SqlSessionFactoryUtils.getSqlSessionFactory();
        //获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = userMapper.select(username,password);
        //释放资源
        sqlSession.close();

        //获取字符输出流并设置content type
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        //判断user是否为null
        if(user != null){
            //登陆成功
            writer.write("登陆成功");
        }else{
            //登陆失败
            writer.write("登陆失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
