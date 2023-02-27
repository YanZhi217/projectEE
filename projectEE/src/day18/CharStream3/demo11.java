package day18.CharStream3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class demo11 {
    public static void main(String[] args) throws IOException {
        //字符缓冲流的特有功能
        //字符缓冲输出流BufferedWrite ： newLine  跨平台的换行符


        //创建对象
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\develop\\projectEE\\a.txt"));


        //写出数据
        bw.write("你好世界!666");
        //跨平台的回车换行
        bw.newLine();
        bw.write("abcdef");
        //跨平台的回车换行
        bw.newLine();
        bw.write("-------------");

        //刷新流
        bw.flush();
        //释放资源
        bw.close();
    }
}
