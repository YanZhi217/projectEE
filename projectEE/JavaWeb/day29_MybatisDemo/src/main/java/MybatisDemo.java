import Pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis代理开发
 */
public class MybatisDemo {
    public static void main(String[] args) throws IOException {
        //加载mybatis的核心配置文件,获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //session翻译会话
        //获取sqlSession对象,用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        List<User> users = sqlSession.selectList("Mapper.UserMapper.selectAll");
        System.out.println(users);

        //释放资源
        sqlSession.close();

    }
}
