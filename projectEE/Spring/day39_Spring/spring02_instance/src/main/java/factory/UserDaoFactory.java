package factory;

import dao.UserDao;
import dao.impl.UserDaoImpl;
//实例工厂创建对象
public class UserDaoFactory {
    public UserDao getUserDao(){
        return new UserDaoImpl();
    }
}
