package dao.impl;

import dao.BookDao;

public class BookDaoImpl implements BookDao {

    //bean本质上就是对象，创建bean使用无参构造方法完成
    //无参构造方法如果不存在将会抛出BeanCreateException异常
    public BookDaoImpl() {
        System.out.println("book dao constructor is running ....");
    }

    public void save() {
        System.out.println("book dao save ...");
    }

}
