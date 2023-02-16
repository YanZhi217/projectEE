package day11.Service;

import day11.Dao.OtherTeacherDao;
import day11.domain.Teacher;

public class TeacherService {
    private final OtherTeacherDao teacherdao = new OtherTeacherDao();
    //检查学号是否存在
    public boolean isExists(String id) {
        Teacher[] teas = teacherdao.findAllTeacher();
        boolean flag = false;

        for (Teacher teacher : teas) {
            if (teacher != null && teacher.getId().equals(id)) {
                flag = true;
                break;
            }
        }

        return flag;
    }
    //添加老师
    public boolean addTeacher(Teacher tea){
        return teacherdao.addTeacher(tea);
    }

    //返回所有老师对象
    public Teacher[] findAllTeacher() {
        Teacher[] teas = teacherdao.findAllTeacher();
        boolean flag = false;

        for (Teacher tea : teas) {
            if (tea != null) {
                flag = true;
                break;
            }
        }

        if(flag){
            return teas;
        }else{
            return null;
        }
    }

    //删除老师
    public void deleteTeacherById(String id) {
        teacherdao.deleteTeacherById(id);
    }

    public void updateTeacher(String id,Teacher newTea) {
        teacherdao.updateTeacher(id,newTea);
    }
}
