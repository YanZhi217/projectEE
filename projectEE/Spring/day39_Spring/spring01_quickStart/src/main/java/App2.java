import dao.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

public class App2 {
    public static void main(String[] args) {
        //获取IoC容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取Bean
        /*BookDao bookDao = (BookDao)applicationContext.getBean("bookDao");
        bookDao.save();*/

        BookService bookService = (BookService) applicationContext.getBean("bookService");
        bookService.save();
    }
}
