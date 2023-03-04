package day27_JDBC.JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo4 {
    /*
        JDBC API Statement
        Statement对象的作用就是用来执行SQL语句的，而针对不同类型的SQL语句使用的方法也不一样
        执行DDL，DML语句使用executeUpdate(sql)语句，DDL，操作数据库和数据表，DML，操作数据表增删改
        执行DQL语句使用executeQuery(sql)语句，DQL，操作数据表查询,返回ResultSet结果集对象
        开发中很少使用Java代码操作DDL语句
    */

        /**
         * 执行DML语句
         */
        @Test
        public void testDML () throws Exception {
            //1. 注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
            String url = "jdbc:mysql:///db1?useSSL=false";
            String username = "root";
            String password = "1234";
            Connection conn = DriverManager.getConnection(url, username, password);
            //3. 定义sql
            String sql = "update account set money = 3000 where id = 1";
            //4. 获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //5. 执行sql
            int count = stmt.executeUpdate(sql);//执行完DML语句，受影响的行数
            //6. 处理结果
            //System.out.println(count);
            if (count > 0) {
                System.out.println("修改成功~");
            } else {

                System.out.println("修改失败~");
            }
            //7. 释放资源
            stmt.close();
            conn.close();

        }


        /**
         * 执行DDL语句
         */
        @Test
        public void testDDL () throws Exception {
            //1. 注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
            String url = "jdbc:mysql:///db1?useSSL=false";
            String username = "root";
            String password = "1234";
            Connection conn = DriverManager.getConnection(url, username, password);
            //3. 定义sql
            String sql = "DROP DATABASE db2";
            //4. 获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //5. 执行sql
            int count = stmt.executeUpdate(sql);//执行完DDL语句，可能是0
            //6. 处理结果
            //System.out.println(count);
       /* if(count > 0){
            System.out.println("修改成功~");
        }else{

            System.out.println("修改失败~");
        }*/
            System.out.println(count);

            //7. 释放资源
            stmt.close();
            conn.close();

        }
}
