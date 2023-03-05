package day27_JDBC.Druid2;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * Druid数据库连接池演示
 * 标准接口：==DataSource==
 * 官方(SUN) 提供的数据库连接池标准接口，由第三方组织实现此接口。该接口提供了获取连接的功能：Connection getConnection()
 * 那么以后就不需要通过DriverManager 对象获取Connection对象，而是通过连接池（DataSource）获取Connection对象。
 * 常见的数据库连接池DBCP、C3P0、Druid
 * Druid（德鲁伊）
 * Druid连接池是阿里巴巴开源的数据库连接池项目
 * 功能强大，性能优秀，是Java语言最好的数据库连接池之一
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        //2.定义配置文件
        //3. 加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("JavaWeb/druid.properties"));
        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5. 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        System.out.println(connection);


        //System.out.println(System.getProperty("user.dir"));
    }
}