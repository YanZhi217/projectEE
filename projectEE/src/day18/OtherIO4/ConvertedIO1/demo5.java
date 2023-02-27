package day18.OtherIO4.ConvertedIO1;

import java.io.*;

public class demo5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //1.写对象
        //2.修改javabean类(在此指User类)
        /*
        JavaBean 是特殊的 Java 类，使用 Java 语言书写，并且遵守 JavaBean API 规范。
        接下来给出的是 JavaBean 与其它 Java 类相比而言独一无二的特征：
        提供一个默认的无参构造函数。
        需要被序列化并且实现了 Serializable 接口。
        可能有一系列可读写属性。
        可能有一系列的 getter 或 setter 方法。
        */
        //3.读对象

        //写对象 --- 序列化
        //method1();

        //读对象 --- 反序列化
        method2();

    }

    private static void method2() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\develop\\projectEE\\a.txt"));
        User o = (User) ois.readObject();
        System.out.println(o);
        ois.close();
    }

    private static void method1() throws IOException {
        User user = new User("zhangsan","qwer");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\develop\\projectEE\\a.txt"));
        oos.writeObject(user);
        oos.close();
    }
}
