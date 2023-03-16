import dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppForLifeCycle {
    public static void main( String[] args ) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //注册关闭钩子函数，在虚拟机退出之前回调此函数，关闭容器
        ctx.registerShutdownHook();
        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
        bookDao.save();

        //暴力关闭容器
        //ctx.close();
    }
}
