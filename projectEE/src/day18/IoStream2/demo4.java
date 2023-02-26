package day18.IoStream2;

import java.io.FileOutputStream;
import java.io.IOException;
public class demo4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\develop\\projectEE\\a.txt");

        //一次打开文件之间写入的数据将不会被清空，而是全部保留

        byte [] bys1 = {'f',98,99};
        fos.write(bys1);

        byte [] bys2 = {97,98,99,100,101,102,103};
        fos.write(bys2,1,2);

        fos.close();
    }
}
