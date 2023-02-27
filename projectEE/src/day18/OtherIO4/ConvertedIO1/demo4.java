package day18.OtherIO4.ConvertedIO1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
public class demo4 {
    /*
        对象操作输入流(对象反序列化流)
    */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //用字节输入流创建一个对象输入流(对象反序列化流)
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.txt"));
        //读入的对象时Object类型,需要墙砖为User类型
        User o = (User) ois.readObject();
        System.out.println(o);
        ois.close();

    }
}
