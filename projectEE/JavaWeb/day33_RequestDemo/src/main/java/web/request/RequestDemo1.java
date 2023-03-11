package web.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * request 获取请求数据
 * Request是请求对象，Response是响应对象。
 * request:获取请求数据
 * 浏览器会发送HTTP请求到后台服务器[Tomcat]
 *  HTTP的请求中会包含很多请求数据[请求行+请求头+请求体]
 * 后台服务器[Tomcat]会对HTTP请求中的数据进行解析并把解析结果存入到一个对象中
 * 所存入的对象即为request对象，所以我们可以从request对象中获取请求的相关参数
 * 获取到数据后就可以继续后续的业务，比如获取用户名和密码就可以实现登录操作的相关业务
 * response:设置响应数据
 * 业务处理完后，后台就需要给前端返回业务处理的结果即响应数据
 * 把响应数据封装到response对象中
 * 后台服务器[Tomcat]会解析response对象,按照[响应行+响应头+响应体]格式拼接结果
 * 浏览器最终解析结果，把内容展示在浏览器给用户浏览
 * ServletRequest和HttpServletRequest是继承关系，并且两个都是接口，接口是无法创建对象，
 * 这个时候，我们就需要用到Request继承体系中的RequestFacade:
 * 该类实现了HttpServletRequest接口，也间接实现了ServletRequest接口。
 * Servlet类中的service方法、doGet方法或者是doPost方法最终都是由Web服务器[Tomcat]来调用的，所以Tomcat提供了方法参数接口的具体实现类，并完成了对象的创建
 * 要想了解RequestFacade中都提供了哪些方法，我们可以直接查看JavaEE的API文档中关于ServletRequest和HttpServletRequest的接口文档
 * 因为RequestFacade实现了其接口就需要重写接口中的方法
 * Request的继承体系为ServletRequest-->HttpServletRequest-->RequestFacade
 * Tomcat需要解析请求数据，封装为request对象,并且创建request对象传递到service方法
 * 使用request对象，可以查阅JavaEE API文档的HttpServletRequest接口中方法说明
 * HTTP请求数据总共分为三部分内容，分别是请求行、请求头、请求体
 * 请求行包含三块内容，分别是请求方式、请求资源路径、HTTP协议及版本
 */
@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // String getMethod()：获取请求方式： GET
        String method = req.getMethod();
        System.out.println(method);//GET
        // String getContextPath()：获取虚拟目录(项目访问路径)：/day33_RequestDemo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        // StringBuffer getRequestURL(): 获取URL(统一资源定位符)：http://localhost:8080/day33_RequestDemo/req1
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        // String getRequestURI()：获取URI(统一资源标识符)： /day33_RequestDemo/req1
        String uri = req.getRequestURI();
        System.out.println(uri);
        // String getQueryString()：获取请求参数（GET方式）： username=zhangsan
        String queryString = req.getQueryString();
        System.out.println(queryString);


        //---------------------------------------------
        /*
            由于获取请求参数的方式不同，导致doGet和doPost中出现了重复代码println()(可以理解为多行的业务代码)
            如何解决呢
        */
        // 获取请求头：user-agent: 浏览器的版本信息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求体：请求参数

        //1. 获取字符输入流
        /*
        BufferedReader流是通过request对象来获取的，当请求完成后request对象就会被销毁，
        request对象被销毁后，BufferedReader流就会自动关闭，所以此处就不需要手动关闭流了。
        */
        BufferedReader br = req.getReader();
        //2. 读取数据
        String line = br.readLine();
        System.out.println(line);


    }
}
