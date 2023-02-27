package day18.CharStream3;

import java.io.FileWriter;
import java.io.IOException;
public class demo5 {
    public static void main(String[] args) throws IOException {
        //flush()刷新流。刷新完毕之后，还可以继续写数据
        //close()关闭流。释放资源。一旦关闭，就不能写数据

        FileWriter fw = new FileWriter("D:\\develop\\projectEE\\a.txt");

        fw.write("你好世界!");
        //fw.flush();
        fw.write("666");
        //fw.flush();

        fw.close();

        fw.write("aaa");//Stream closed
    }
}
