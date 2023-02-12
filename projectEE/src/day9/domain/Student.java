package day9.domain;

public class Student {
    private String sid;     //学号
    private String name;    //姓名
    private int age;        //年龄
    private String birthday;//生日

    //无参构造
    public Student() {}

    //有参构造
    public Student(String sid, String name, int age, String birthday) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }
    //学号
    public String getSid() { return sid; }

    public void setSid(String sid) { this.sid = sid; }

    //姓名
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    //年龄
    public int getAge() { return age; }

    public void setAge(int age) { this.age = age; }

    //生日
    public String getBirthday() { return birthday; }

    public void setBirthday(String birthday) { this.birthday = birthday; }
}
