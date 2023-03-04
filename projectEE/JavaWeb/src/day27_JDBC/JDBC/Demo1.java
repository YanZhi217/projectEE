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
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1"; //连接的路径
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        //3. 定义sql
        String sql = "UPDATE account SET money = 2000 WHERE id = 1";

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
