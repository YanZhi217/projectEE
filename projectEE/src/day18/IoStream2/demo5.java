package day18.IoStream2;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo5 {
    public static void main(String[] args) throws IOException {
        //第二个参数就是续写开关,如果没有传递,默认就是false,
        //表示不打开续写功能,那么创建对象的这行代码会清空文件.

        //如果第二个参数为true,表示打开续写功能
        //那么创建对象的这行代码不会清空文件.
        FileOutputStream fos = new FileOutputStream("D:\\develop\\projectEE\\a.txt",true);

        //getBytes()作用:使字符串转换为字节数组，widows中\r\n代表换行，linux中为\n,mac中为\r
        fos.write(97);
        //能加一个换行
        fos.write("\r\n".getBytes());
        fos.write(98);
        //能加一个换行
        fos.write("\r\n".getBytes());
        fos.write(99);
        //能加一个换行
        fos.write("\r\n".getBytes());
        fos.write(100);
        //能加一个换行
        fos.write("\r\n".getBytes());
        fos.write(101);
        //能加一个换行
        fos.write("\r\n".getBytes());

        fos.close();
    }
}
