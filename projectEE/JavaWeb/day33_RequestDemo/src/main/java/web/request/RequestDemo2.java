package web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * request 通用方式获取请求参数
 * 发送一个GET请求并携带用户名，后台接收后打印到控制台
 * 发送一个POST请求并携带用户名，后台接收后打印到控制台
 * 可以在doGet中调用doPost,在doPost中完成参数的获取和打印,另外需要注意的是，doGet和doPost方法都必须存在，不能删除任意一个。
 * GET请求和POST请求获取请求参数的方式不一样，在获取请求参数这块该如何实现呢?
 * GET请求方式和POST请求方式区别主要在于获取请求参数的方式不一样，是否可以提供一种统一获取请求参数的方式，从而统一doGet和doPost方法内的代码?
 * 使用request的getMethod()来获取请求方式，根据请求方式的不同分别获取请求参数值，这样就可以解决上述问题，但是以后每个Servlet都需要这样写代码
 * 实现起来比较麻烦，这种方案我们不采用
 * ServletRequest对象已经将上述获取请求参数的方法进行了封装，并且ServletRequest提供的方法实现的功能更强大，以后只需要调用request提供的方法即可，
 * 获取所有参数Map集合
 * 因为参数的值可能是一个，也可能有多个，所以Map的值的类型为String数组。
 * Map<String,String[]> getParameterMap()
 * 根据名称获取参数值（数组）
 * String[] getParameterValues(String name)
 * 根据名称获取参数值(单个值)
 * String getParameter(String name)
 */
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
        //System.out.println("get....");

        //1. 获取所有参数的Map集合
        //ServletRequest为我们提供了获取集合的方法,getParameterMap()
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            // username:zhangsan lisi
            System.out.print(key+":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        System.out.println("------------");

        //2. 根据key获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {

            System.out.println(hobby);
        }

        //3. 根据key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //POST请求逻辑

        this.doGet(req,resp);

        /*System.out.println("post....");

        //1. 获取所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {
            // username:zhangsan lisi
            System.out.print(key+":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }

            System.out.println();
        }

        System.out.println("------------");

        //2. 根据key获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {

            System.out.println(hobby);
        }

        //3. 根据key 获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username);
        System.out.println(password);*/


    }
}
