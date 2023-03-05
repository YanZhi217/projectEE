package day27_JDBC.JDBC1;

import java.sql.*;

public class Demo5 {
    /*
        JDBC快速入门
    */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. 注册驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false"; //连接的路径
        Connection conn = DriverManager.getConnection(url, "root", "1234");

        //3.定义Statement对象
        Statement sttm = conn.createStatement();

        //4.定义SQL语句
        String sql = "SELECT * FROM account";

        //5.执行SQL语句,返回ResultSet结果集
        ResultSet rs = sttm.executeQuery(sql);

        //6.处理结果
        //6. 处理结果， 遍历rs中的所有数据
       /* // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据  getXxx()
            int id = rs.getInt(1);
            String name = rs.getString(2);
            double money = rs.getDouble(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("--------------");

        }*/

        // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据  getXxx()
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            System.out.print(id + "\t\t");
            System.out.print(name + "\t\t");
            System.out.println(money);

            System.out.println("---------------------------");

        }


        //7. 释放资源
        rs.close();
        sttm.close();
        conn.close();

    }
}
