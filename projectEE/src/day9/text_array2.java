package day9;
    //调用其他类中的方法时，如果不在同一个包里，则需要导包。即import
public class text_array2 {
    /*
        需求：将（张三，23）（李四，24）（王五，25）
            封装为3个学生对象并存入数组
            随后遍历数组，将学生信息输出在控制台

        思路：
            1. 定义学生类准备用于封装数据
            2. 动态初始化长度为3的数组，类型为Student类型
            3. 根据需求创建3个学生对象
            4. 将学生对象存入数组
            5. 遍历数组，取出每一个学生对象
            6. 调用对象的getXxx方法获取学生信息，并输出在控制台
    */
    public static void main(String[] args) {
        // 2. 动态初始化长度为3的数组，类型为Student类型
        array_domain1[] arr = new array_domain1[3];
        // 3. 根据需求创建3个学生对象
        array_domain1 stu1 = new array_domain1("张三",23);
        array_domain1 stu2 = new array_domain1("李四",24);
        array_domain1 stu3 = new array_domain1("王五",25);
        // 4. 将学生对象存入数组
        arr[0] = stu1;
        arr[1] = stu2;
        arr[2] = stu3;
        // 5. 遍历数组，取出每一个学生对象
        for (int i = 0; i < arr.length; i++) {
            array_domain1 temp = arr[i];
            System.out.println(temp.getName() + "..." + temp.getAge());
        }
    }
}
