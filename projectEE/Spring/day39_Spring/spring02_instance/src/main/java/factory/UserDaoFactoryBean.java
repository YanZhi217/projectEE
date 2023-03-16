package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import org.springframework.beans.factory.FactoryBean;
//FactoryBean创建对象
public class UserDaoFactoryBean implements FactoryBean<UserDao> {
    //代替原始实例工厂中创建对象的方法
    public UserDao getObject() throws Exception {
        return new UserDaoImpl();
    }

    public Class<?> getObjectType() {
        return UserDao.class;
    }

    @Override
    public boolean isSingleton() {
        //return FactoryBean.super.isSingleton();
        return true;//单例
        //false 非单例
    }
}
