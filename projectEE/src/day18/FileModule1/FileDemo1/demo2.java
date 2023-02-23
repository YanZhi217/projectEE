package day18.FileModule1.FileDemo1;

import java.io.File;
import java.io.IOException;

public class demo2 {
    public static void main(String[] args) throws IOException {
        //这个路径固定不变了.
        File file = new File("D:\\develop\\projectEE\\src\\day18\\File1\\FileModule1\\FileDemo1\\a.txt");

        //当前项目下的a.txt
        File file2 = new File("a.txt");


        //当前项目下 --- 指定模块下的 a.txt
        File file3 = new File("D:\\develop\\projectEE\\a.txt");
        file3.createNewFile();
    }

}
