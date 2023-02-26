package day18.IoStream2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class demo1 {
    public static void main(String[] args) throws IOException {
        //1.创建字节输出流的对象 --- 告诉虚拟机我要往哪个文件中写数据了
        //字节流能够操作非纯文本文件，不能用windows记事本直接打开的就是非纯文本文件
        //字符流能够操作纯文本文件
        FileOutputStream fos = new FileOutputStream("D:\\a.txt");
        //FileOutputStream fos = new FileOutputStream(new File("D:\\a.txt"));

        //2,写数据
        fos.write(97);

        //3,释放资源
        fos.close();


    }

}
