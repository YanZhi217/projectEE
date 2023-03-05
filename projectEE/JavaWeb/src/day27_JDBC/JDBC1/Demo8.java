package day27_JDBC.JDBC1;

import org.junit.Test;

import java.sql.*;

/**
 * API详解：PreparedStatement 原理
 * 好处：预编译SQL，性能更高
 *防止SQL注入，将敏感字符进行转义
 * PrepareStatement预编译开启：useServerPrepStmts=true
 * 在获取PrepareStatement对象时，将sql语句发送给服务器进行检查，编译，（这些步骤很消耗时间）
 * 执行时就不用再进行这些步骤了，速度更快
 * 如果sql模板一样，则只需要进行一次检查，编译
 */
public class Demo8 {
    @Test
    public void testPreparedStatement() throws  Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";

        Connection conn = DriverManager.getConnection(url,"root","1234");

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "' or '1' = '1";

        // 定义sql,参数值使用?替代
        String sql = "select * from tb_user where username = ? and password = ?";

        // 获取PreparedStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // 设置？的值,setXXX(参数1，参数2),参数1，?编号的位置(从1开始)，参数2，?的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);

        // 执行sql，不需要再传递sql语句,调用executeUpdate()和executeQuery()方法时不需要传递SQL语句，因为获取SQL语句执行对象时已经对SQL语句进行预编译了。
        //                                      DDL,DML         DQL
        //在预编译的时候，prepareStatement会对sql语句进行转移，"' or '1' = '1" -> "\' \or \'1\' = \'1",就会避免SQL注入问题
        ResultSet rs = pstmt.executeQuery();

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }


    /**
     * PreparedStatement原理
     */
    @Test
    public void testPreparedStatement2() throws  Exception {



        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        // useServerPrepStmts=true 参数开启预编译功能
        String url = "jdbc:mysql:///db1?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        // 定义sql
        String sql = "select * from tb_user where username = ? and password = ?";

        // 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);


        Thread.sleep(100);
        // 设置？的值
        pstmt.setString(1,name);
        pstmt.setString(2,pwd);
        ResultSet rs = null;
        // 执行sql
        rs = pstmt.executeQuery();


        // 设置？的值
        pstmt.setString(1,"aaa");
        pstmt.setString(2,"bbb");

        // 执行sql
        rs = pstmt.executeQuery();


        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }

}
