package day11.Dao;

import day11.domain.Teacher;

public class TeacherDao {
    public static Teacher[] teas = new Teacher[5];

    //返回所有老师对象
    public Teacher[] findAllTeacher() {
        return teas;
    }

    //添加老师
    public boolean addTeacher(Teacher tea) {
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher teacher = teas[i];
            if(teacher == null){
                index = i;
                break;
            }
        }

        if(index == -1){
            return false;
        }else{
            teas[index] = tea;
            return true;
        }
    }

    //删除老师
    public void deleteTeacherById(String id) {
        int index = getIndex(id);
        teas[index] = null;
    }

    //查找编号所在索引
    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < teas.length; i++) {
            Teacher tea = teas[i];
            if(tea != null && tea.getId().equals(id)){
                index = i;
                break;
            }
        }
        return index;
    }

    //修改老师
    public void updateTeacher(String id,Teacher newTea) {
        int index = getIndex(id);
        teas[index] = newTea;
    }
}
