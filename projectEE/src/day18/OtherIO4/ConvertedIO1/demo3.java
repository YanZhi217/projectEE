package day18.OtherIO4.ConvertedIO1;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class demo3 {
    public static void main(String[] args) throws IOException {
        //对象操作流分为   对象操作输入流ObjectInputStream(对象反序列化流)   和   对象操作输出流ObjectOutputStream(对象序列化流)
        //对象操作输出流   就是将对象写到本地文件中，或者在网络中传输对象
        //对象操作输入流   就是把写到本地文件的对象读到内存中，或者接收网络中传输的对象
        User user = new User("zhangsan","qwer");

        //用字节输出流创建一个对象操作输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\develop\\projectEE\\a.txt"));
        //写入对象，要使类的对象能够被序列化，则必须实现一个接口：Serializable
        oos.writeObject(user);
        oos.close();


    }
}
