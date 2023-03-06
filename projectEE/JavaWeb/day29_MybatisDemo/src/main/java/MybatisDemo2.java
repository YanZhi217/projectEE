import Mapper.UserMapper;
import Pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * mybatis mapper 代理开发
 */
public class MybatisDemo2 {
    public static void main(String[] args) throws IOException {
        //加载mybatis的核心配置文件,获取sqlSessionFactory
        String resource = "mybatis_config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //session 翻译 会话
        //获取sqlSession对象,用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行sql
        //List<User> users = sqlSession.selectList("Test.selectAll");
        //获取UserMapper接口的代理对象
        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(usermapper);     //org.apache.ibatis.binding.MapperProxy@22555ebf
        //与全限定类名调用Java对象类似
        List<User> users = usermapper.selectAll();
        //List<User> users = sqlSession.getMapper(UserMapper.class).selectAll();
        System.out.println(users);

        //释放资源
        sqlSession.close();

    }
}
