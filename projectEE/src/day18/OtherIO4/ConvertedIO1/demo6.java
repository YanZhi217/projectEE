package day18.OtherIO4.ConvertedIO1;

import java.io.*;
public class demo6 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student s1 = new Student("杜子腾",16);
        Student s2 = new Student("张三",23);
        Student s3 = new Student("李四",24);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\develop\\projectEE\\a.txt"));
        oos.writeObject(s1);
        oos.writeObject(s2);
        oos.writeObject(s3);

        oos.close();


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\develop\\projectEE\\a.txt"));
        /*
        这样是错误的
        Object obj;
        while((obj = ois.readObject()) != null){
            System.out.println(obj);
        }
        */

        while(true){
            try {
                Object o = ois.readObject();
                System.out.println(o);
            } catch (EOFException e) {
                break;
            }
        }
        ois.close();
    }
}
