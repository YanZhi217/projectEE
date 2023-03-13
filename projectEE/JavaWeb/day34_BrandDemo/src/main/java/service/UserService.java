package service;

import mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import pojo.User;
import util.SqlSessionFactoryUtils;

public class UserService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    //登陆
    public User login(String username, String password){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = mapper.select(username, password);
        //释放资源
        sqlSession.close();

        return user;
    }

    //注册
    public Boolean register(User user){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        //判断用户名是否存在
        User u = mapper.selectByUsername(user.getUsername());
        if(u == null){
            //用户名不存在,注册
            mapper.add(user);
            //提交事务
            sqlSession.commit();
        }
        //释放资源
        sqlSession.close();;
        return u == null;
    }

    //AJAX判断用户名是否存在
    public Boolean SelectUser(String username){
        //获取sqlSession
        SqlSession sqlSession = factory.openSession();
        //获取UserMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        //判断用户名是否存在
        User u = mapper.selectByUsername(username);
        return u != null;
    }
}
