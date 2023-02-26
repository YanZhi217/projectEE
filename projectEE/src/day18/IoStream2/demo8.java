package day18.IoStream2;

import java.io.FileInputStream;
import java.io.IOException;
public class demo8 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\develop\\projectEE\\a.txt");
        //1,文件中多个字节我怎么办?
        /*
        while(true){
            int i1 = fis.read();
            System.out.println(i1);
        }
        */

        int b;
        while ((b = fis.read())!=-1){
            System.out.print((char) b);
        }
        fis.close();
    }
}
