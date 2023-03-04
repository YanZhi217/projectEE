package day27_JDBC.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
    /*
        JDBC快速入门
    */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        //com.mysql.jdbc.Driver底层使用DriverManager.registerDriver(Driver driver)来注册给定的驱动程序
        //MySQL5版本之后的驱动包，可以省略注册驱动的步骤，自动加载jar包中的META-INF/services/java.sql.Driver文件中的驱动类
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1"; //连接的路径
        //语法：jdbc:mysql://ip地址（域名）:端口号/数据库名称?参数键值对1&参数键值对2...
        //示例：jdbc:mysql://127.0.0.1:3306/db1
        //细节：如果连接的是本机的服务器，并且mysql端口号是3306，则URL可以简写为：jdbc:mysql:///数据库名称？参数键值对
        //配置useSSL = false参数，禁用安全连接方式，解决警告提示
        String username = "root";
        String password = "1234";
        //DriverManager()驱动管理类,注册驱动，获取数据库连接,是一个工具类，里面有许多静态方法
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "update account set money = 2000 where id = 1";

        //4. 获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();

        //5. 执行sql
        int count = stmt.executeUpdate(sql);//返回受影响的行数

        //6. 处理结果
        System.out.println(count);

        //7. 释放资源
        stmt.close();
        conn.close();

    }
}
