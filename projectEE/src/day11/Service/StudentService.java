package day11.Service;

import day11.Dao.StudentDao;
import day11.doamin.Student;

public class StudentService {
    private StudentDao studentdao = new StudentDao();

    public boolean isExists(String id) {
        Student[] stus = studentdao.findAllStudent();
        //假设id不存在
        boolean exists = false;
        //遍历数组，获取每一个学生对象，判断
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student != null && student.getId().equals(id)){
                exists = true;
                break;
            }
        }
        return exists;
    }

    public boolean addStudent(Student stu) {
        //创建StudentDao对象
        //将学生对象传递给Dao的StudentDao的addStudent()
        //将返回的boolean类型返回给StudentController
        return studentdao.addStudent(stu);

    }
}
