package service.impl;

import dao.BookDao;
import dao.UserDao;
import service.BookService;

public class BookServiceImpl implements BookService{
    private final BookDao bookDao;
    private final UserDao userDao;

    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("book service save ...");
        bookDao.save();
        userDao.save();
    }
}
