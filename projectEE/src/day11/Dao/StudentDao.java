package day11.Dao;

import day11.domain.Student;

public class StudentDao implements BaseStudentDao{
    //创建学生对象数组
    public static Student[] stus = new Student[5];

    static {
        Student stu1 = new Student("YanZhi001","张三","18","20020422");
        Student stu2 = new Student("YanZhi002","李四","21","20020421");
        stus[0] = stu1;
        stus[1] = stu2;
    }

    //返回学生对象数组
    public Student[] findAllStudent() {
        return stus;
    }

    //添加学生到数组
    public boolean addStudent(Student stu) {

        //添加学生到数组
        //定义变量index=-1,假设数组已经存满,没有null元素
        int index = -1;
        //遍历数组，判断null
        for (int i = 0; i < stus.length; i++) {
            Student student = stus[i];
            if(student == null){
                index = i;
                break;
            }
        }

        //返回是否添加成功的boolean状态
        if(index == -1){
            return false;
        }else{
            stus[index] = stu;
            return true;
        }

    }

    //删除学生
    public void deleteStudentById(String delId) {
        //查找学生id所在的索引
        int index = getIndex(delId);
        //将该索引覆盖为null
        stus[index] = null;
    }

    //查找id索引位置
    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stus.length; i++) {
            Student stu = stus[i];
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
        stus[index] = newStu;
    }
}
