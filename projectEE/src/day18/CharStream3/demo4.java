package day18.CharStream3;

import java.io.FileWriter;
import java.io.IOException;
public class demo4 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("D:\\develop\\projectEE\\a.txt");

        //fw.write("你好世界!");
        //fw.write(97);
        fw.write("97");

        fw.close();
    }
}
