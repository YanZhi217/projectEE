package web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

//访问路径
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /*
        由servlet容器调用以允许 servlet 响应请求。
        此方法仅在 servlet 的 init（） 方法成功完成后调用。
        响应的状态代码应始终为抛出或发送错误的 servlet 设置。
        Servlet 通常在多线程 Servlet 容器中运行，这些容器可以同时处理多个请求。开发人员必须注意同步对任何共享资源的访问，
        例如文件、网络连接以及 servlet 的类和实例变量。有关 Java 中多线程编程的更多信息，请参阅有关多线程编程的 Java 教程。
    */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("Servlet hello world~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
