package day11.Service;

import day11.Dao.StudentDao;
import day11.doamin.Student;

public class StudentService {

    public boolean addStudent(Student stu) {
        //创建StudentDao对象
        StudentDao studentDao = new StudentDao();

        //将学生对象传递给Dao的StudentDao的addStudent()
        //将返回的boolean类型返回给StudentController

       return studentDao.addStudent(stu);

    }
}
