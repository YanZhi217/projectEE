package day18.CharStream3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class demo6 {
    public static void main(String[] args) throws IOException {
        //创建字符输入流的对象
        // FileReader fr = new FileReader(new File("charstream\\a.txt"));
        FileReader fr = new FileReader("D:\\develop\\projectEE\\a.txt");


        //读取数据
        //一次读取一个字符
        int ch;
        while((ch = fr.read()) != -1){
            System.out.println((char) ch);
        }

        //释放资源
        fr.close();
    }
}
