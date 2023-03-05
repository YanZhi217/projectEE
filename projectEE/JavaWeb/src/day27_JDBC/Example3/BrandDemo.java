package day27_JDBC.Example3;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 品牌数据的增删改查操作
 */
public class BrandDemo {
    //获取当前默认路径
    @Test
    public void getRoad(){
        System.out.println(System.getProperty("user.dir"));
    }

    /**
     * 查询所有
     * 1. SQL：select * from tb_brand;
     * 2. 参数：不需要
     * 3. 结果：List<Brand>
     */
    @Test
    public void testSelectAll() throws Exception {
        //1. 获取Connection
        //1.1 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("druid.properties"));
        //1.2 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //1.3 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = "select * from tb_brand;";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        //5. 执行SQL
        ResultSet rs = pstmt.executeQuery();

        //6. 处理结果 List<Brand> 封装Brand对象，装载List集合
        Brand brand = null;
        List<Brand> brands = new ArrayList<>();
        while (rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name");
            int ordered = rs.getInt("ordered");
            String description = rs.getString("description");
            int status = rs.getInt("status");
            //封装Brand对象
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            //装载集合
            brands.add(brand);

        }
        System.out.println(brands);
        //7. 释放资源
        rs.close();
        pstmt.close();
        conn.close();
    }


    /**
     * 添加
     * 1. SQL：insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
     * 2. 参数：需要，除了id之外的所有参数信息
     * 3. 结果：boolean
     */
    @Test
    public void testAdd() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        //1. 获取Connection
        //1.1 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("druid.properties"));
        //1.2 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        //1.3 获取数据库连接 Connection
        Connection conn = dataSource.getConnection();

        //2. 定义SQL
        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);";

        //3. 获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4. 设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();
    }


    /**
     * 修改
     * 1. SQL：
        update tb_brand
        set brand_name  = ?,
        company_name= ?,
        ordered     = ?,
        description = ?,
        status      = ?
        where id = ?
     * 2. 参数：需要，所有数据
     * 3. 结果：boolean
     */
    @Test
    public void testUpdate() throws Exception {
        // 接收页面提交的参数
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1000;
        String description = "绕地球三圈";
        int status = 1;
        int id = 4;

        //获取Connection
        Properties prop = new Properties();
        //加载配置文件
        prop.load(new FileInputStream("druid.properties"));
        //获取连接池对象
        DataSource datasource = DruidDataSourceFactory.createDataSource(prop);
        //获取数据库连接
        Connection conn = datasource.getConnection();

        //定义SQL
        String sql = "UPDATE tb_brand\n" +
                "SET brand_name = ?,\n" +
                "company_name= ?,\n" +
                "ordered = ?,\n" +
                "description = ?,\n" +
                "status = ?\n" +
                "WHERE id = ?\n";

        //获取pstmt对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数
        //6. 处理结果
        System.out.println(count > 0);


        //7. 释放资源
        pstmt.close();
        conn.close();
    }

    /**
     * 删除
     * 1. SQL：
        delete from tb_brand where id = ?
     * 2. 参数：需要，id
     * 3. 结果：boolean
     */
    @Test
    public void delete() throws Exception {

        // 接收页面提交的参数
        int id = 4;

        //获取数据库连接
        Properties prop = new Properties();
        prop.load(new FileInputStream("druid.properties"));
        DataSource datasource = DruidDataSourceFactory.createDataSource(prop);
        Connection conn = datasource.getConnection();

        //定义SQL
        String sql = "DELETE FROM tb_brand WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1,id);

        //5. 执行SQL
        int count = pstmt.executeUpdate(); // 影响的行数

        //6. 处理结果
        System.out.println(count > 0);

        //7. 释放资源
        pstmt.close();
        conn.close();
    }
}
