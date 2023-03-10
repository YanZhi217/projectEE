package web.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 中文乱码问题解决方案
 * POST请求解决方案
 * 分析出现中文乱码的原因：
 * POST的请求参数是通过request的getReader()来获取流中的数据,TOMCAT在获取流的时候采用的编码是ISO-8859-1,ISO-8859-1编码是不支持中文的，所以会出现乱码
 * 解决方案：
 * 页面设置的编码格式为UTF-8,把TOMCAT在获取流数据之前的编码设置为UTF-8,通过request.setCharacterEncoding("UTF-8")设置编码,UTF-8也可以写成小写
 *
 * GET请求获取请求参数的方式是request.getQueryString(),POST请求获取请求参数的方式是request.getReader()
 * request.setCharacterEncoding("utf-8")是设置request处理流的编码,getQueryString方法并没有通过流的方式获取数据
 * 浏览器通过HTTP协议发送请求和数据给后台服务器（Tomcat)
 * 浏览器在发送HTTP的过程中会对中文数据进行URL
 * 浏览器在发送HTTP1的过程中会对中文数据进行URL编码
 * 在进行URL编码的时候会采用页面<meta>标签指定的UTF-8的方式进行编码,张三编码后的结果就是%E5%BC%A0%E4%B8%89
 * 后台服务器(Tomcat)接收到%E5%BC%A0%E4%B8%89后会默认按照ISO-8859-1进行URL解码
 * 由于前后编码与解码采用的格式不一样，就会导致后台获取到的数据为乱码。
 *
 * 浏览器把中文参数按照UTF-8进行URL编码
 * Tomcat对获取到的内容进行了ISO-8859-1的URL解码
 * 在控制台就会出现类上å¼ ä¸的乱码，最后一位是个空格
 *
 * 把request.setCharacterEncoding("UTF-8")代码注释掉后，会发现GET请求参数乱码解决方案同时也把POST请求参数乱码的问题解决了
 * 只不过对于POST请求参数一般都会比较多，采用这种方式解决乱码起来比较麻烦，所以对于POST请求还是建议使用设置编码的方式进行。
 * Tomcat8.0之后，已将GET请求乱码问题解决，设置默认的解码方式为UTF-8
 */
@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 解决POST中文乱码：POST，getReader()
        //request.setCharacterEncoding("UTF-8");//设置字符输入流的编码

        //2. 获取username
        String username = request.getParameter("username");
        System.out.println("解决乱码前："+username);

        //3. GET,获取参数的方式：getQueryString
        // 乱码原因：tomcat进行URL解码，默认的字符集ISO-8859-1
       /* //3.1 先对乱码数据进行编码：转为字节数组
        byte[] bytes = username.getBytes(StandardCharsets.ISO_8859_1);
        //3.2 字节数组解码
        username = new String(bytes, StandardCharsets.UTF_8);*/

        username  = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);

        System.out.println("解决乱码后："+username);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
