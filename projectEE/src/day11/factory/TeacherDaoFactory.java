package day11.factory;

import day11.Dao.BaseTeacherDao;
import day11.Dao.OtherTeacherDao;

public class TeacherDaoFactory {
    public static BaseTeacherDao getTeacherDao(){
        return new OtherTeacherDao();
    }
}
