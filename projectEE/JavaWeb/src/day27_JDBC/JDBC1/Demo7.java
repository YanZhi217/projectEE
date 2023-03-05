package day27_JDBC.JDBC1;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 用户登录
 * SQL注入是通过操作输入来修改事先定义好的SQL语句，用以达到执行代码对服务器进行攻击的方法。
 * PreparedStatement作用：预编译SQL语句并执行：预防SQL注入问题
 */
public class Demo7 {
    @Test
    public void testLogin() throws  Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";

        // 获取stmt对象
        Statement stmt = conn.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }


    /**
     * 演示SQL注入
     */
    @Test
    public void testLogin_Inject() throws  Exception {
        //2. 获取连接：如果连接的是本机mysql并且端口是默认的 3306 可以简化书写
        String url = "jdbc:mysql:///db1?useSSL=false";
        String username = "root";
        String password = "1234";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 接收用户输入 用户名和密码
        String name = "hfkjsfhskj";
        String pwd = "' or '1' = '1";

        String sql = "select * from tb_user where username = '"+name+"' and password = '"+pwd+"'";
        //拼接后的sql语句如下:select * from tb_user where username = 'sjdljfld' and password = ''or '1' = '1'
        //从上面语句可以看出条件 username = 'sjdljfld' and password = '' 不管是否满足，而 or 后面的 '1' = '1' 是始终满足的，最终条件是成立的
        //就可以正常的进行登陆了。
        System.out.println(sql);
        // 获取stmt对象
        Statement stmt = conn.createStatement();
        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录是否成功
        if(rs.next()){
            System.out.println("登录成功~");
        }else{
            System.out.println("登录失败~");
        }

        //7. 释放资源
        rs.close();
        stmt.close();
        conn.close();
    }

}
