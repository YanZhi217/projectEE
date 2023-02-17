package day11.Dao;

import day11.domain.Student;
import java.util.ArrayList;
public class OtherStudentDao implements BaseStudentDao{
    //创建学生对象数组
    private final static ArrayList<Student> stus = new ArrayList<>();

    static {
        Student stu1 = new Student("YanZhi001","张三","18","20020422");
        Student stu2 = new Student("YanZhi002","李四","21","20020421");
        stus.add(stu1);
        stus.add(stu2);
    }

    //返回学生对象数组
    public Student[] findAllStudent() {
        Student[] students = new Student[stus.size()];
        for (int i = 0; i < students.length; i++) {
            students[i] = stus.get(i);
        }
        return students;
    }

    //添加学生到数组
    public boolean addStudent(Student stu) {
        stus.add(stu);
        return true;
    }

    //删除学生
    public void deleteStudentById(String delId) {
        //查找学生id所在的索引
        int index = getIndex(delId);
        stus.remove(index);
    }

    //查找id索引位置
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.size(); i++) {
            Student stu = stus.get(i);
            if(stu != null && stu.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    //修改学生
    public void updateStudentById(String updateId, Student newStu) {
        //找索引位置
        int index = getIndex(updateId);
        //使用新的学生对象替换
        stus.set(index,newStu);
    }
}
