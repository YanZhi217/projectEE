package day11.Service;

import day11.Dao.BaseStudentDao;
import day11.domain.Student;
import day11.factory.StudentDaoFactory;

public class StudentService {
    //创建StudentDao对象
    //private final OtherStudentDao studentdao = new OtherStudentDao();
    private final BaseStudentDao studentdao = StudentDaoFactory.getStudentDao();

    //获取学生对象数组并判断是否有学生信息
    public Student[] findAllStudent() {
        //调用StudentDao中的findAllStudent获取学生对象数组
        Student[] allStudent = studentdao.findAllStudent();
        //判断数组中是否有学生信息
        boolean flag = false;
        for (Student stu : allStudent) {
            if (stu != null) {
                flag = true;
                break;
            }
        }

        if(flag){
            //有信息
            return allStudent;
        }else{
            //无信息
            return null;
        }
    }

    //判断学生学号是否存在
    public boolean isExists(String id) {
        //取出所有学生对象
        Student[] stus = studentdao.findAllStudent();
        //假设id不存在
        boolean exists = false;
        //遍历数组，获取每一个学生对象，判断
        for (Student student : stus) {
            if (student != null && student.getId().equals(id)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    //添加学生
    public boolean addStudent(Student stu) {
        //创建StudentDao对象
        //将学生对象传递给Dao的StudentDao的addStudent()
        //将返回的boolean类型返回给StudentController
        return studentdao.addStudent(stu);
    }

    //删除学生
    public void deleteStudentById(String delId) {
        studentdao.deleteStudentById(delId);
    }

    //修改学生
    public void updateStudentById(String updateId, Student newStu) {
        studentdao.updateStudentById(updateId,newStu);
    }
}
