package day18.IoStream2;

import java.io.FileOutputStream;
import java.io.IOException;
public class demo3 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\develop\\projectEE\\a.txt");
        fos.write(97);
        fos.write(98);
        fos.write(99);

        fos.close();

    }
}
