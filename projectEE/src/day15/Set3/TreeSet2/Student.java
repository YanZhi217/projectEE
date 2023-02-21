package day15.Set3.TreeSet2;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        //按照对象的年龄进行排序
        //主要判断条件
        //this.age代表将要存入的对象的年龄，o.age代表上一个已经存入的对象的年龄，将两个作比较
        // 返回值为负数则当前元素较小，存左边，返回值为零则重复，丢掉，证书，较大，存右边
        //判断一次后o.age将会指向更上一个元素，继续判断，直到无元素判断
        int result = this.age - o.age;
        //次要判断条件
        //如果年龄重复则判断姓名是否相同
        result = result == 0 ? this.name.compareTo(o.getName()) : result;
        return result;
    }
}
