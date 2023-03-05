package day27_JDBC.JDBC1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3 {
    /*
        JDBC API
    */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql:///db1?useSSL=false"; //连接的路径
        //Connection()数据库连接对象，作用：1、获取执行SQL的对象，2、管理事务
        //1、
        //普通执行SQL对象,Statement createStatement()
        //预编译SQL的执行SQL对象：防止SQL注入,PreparedStatement  prepareStatement(sql)
        //执行存储过程的对象,CallableStatement prepareCall(sql),通过这种方式获取的CallableStatement 执行对象是用来执行存储过程的,而存储过程在MySQL中不常用
        //2、
        //setAutoCommit(),将此连接的自动提交模式设置为给定的状态,开启事务
        //commit(),提交事务
        //rollback(),回滚事务
        Connection conn = DriverManager.getConnection(url, "root", "1234");
        Statement stmt = null;

        try {
            //开启事务
            conn.setAutoCommit(false);

            //3. 定义sql
            String sql1 = "UPDATE account SET money = 3000 WHERE id = 1";
            String sql2 = "UPDATE account SET money = 3000 WHERE id = 2";

            //4. 获取执行sql的对象 Statement
            stmt = conn.createStatement();

            //5. 执行sql
            int count1 = stmt.executeUpdate(sql1);//返回受影响的行数
            int count2 = stmt.executeUpdate(sql2);

            //6. 处理结果
            System.out.println(count1);
            System.out.println(count2);

            //提交事务
            conn.commit();
        } catch (Exception e) {
            //回滚事务
            conn.rollback();
            throw new RuntimeException(e);
        }

        //7. 释放资源
        stmt.close();
        conn.close();

    }
}
