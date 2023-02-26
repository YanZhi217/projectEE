package day18.IoStream2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class demo9 {
    public static void main(String[] args) throws IOException {
        //创建了字节输入流,准备读数据.
        FileInputStream fis = new FileInputStream("D:\\develop\\projectEE\\a.txt");
        //创建了字节输出流,准备写数据.
        FileOutputStream fos = new FileOutputStream("D:\\develop\\projectEE\\b.txt");

        int b;
        while((b = fis.read())!=-1){
            fos.write(b);
        }

        fis.close();
        fos.close();
    }

}
