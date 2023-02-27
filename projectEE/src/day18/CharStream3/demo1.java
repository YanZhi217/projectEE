package day18.CharStream3;

import java.io.FileInputStream;
import java.io.IOException;

public class demo1 {
    //字节流虽然可以操作文件，但是操作中文时可能出现乱码，所以使用字符流，字符流 = 字节流 + 编码表
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\develop\\projectEE\\a.txt");
        int b ;
        while((b = fis.read()) != -1){
            System.out.println((char) b);
        }
        fis.close();
    }
}
