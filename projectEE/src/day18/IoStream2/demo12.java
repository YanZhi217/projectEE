package day18.IoStream2;

import java.io.*;
public class demo12 {
    public static void main(String[] args) throws IOException {
        //缓冲流结合数组，进行文件拷贝

        //创建一个字节缓冲输入流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\YanZhi\\Desktop\\1.pdf"));

        //创建一个字节缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\YanZhi\\Desktop\\3.pdf"));

        byte [] bytes = new byte[1024];
        int len;
        while((len = bis.read(bytes)) != -1){
            bos.write(bytes,0,len);
        }

        bis.close();
        bos.close();
    }

}
