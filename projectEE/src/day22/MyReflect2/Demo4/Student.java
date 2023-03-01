package day22.MyReflect2.Demo4;


public class Student {
    public String name;

    public int age;

    public String gender;

    private int money = 300;

    public Student() {
    }

    public Student(String name, int age, String gender, int money) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", money=" + money +
                '}';
    }

}
