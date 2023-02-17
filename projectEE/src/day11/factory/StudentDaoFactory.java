package day11.factory;

import day11.Dao.BaseStudentDao;
import day11.Dao.OtherStudentDao;

public class StudentDaoFactory {
    public static BaseStudentDao getStudentDao(){
        return new OtherStudentDao();
    }
}
