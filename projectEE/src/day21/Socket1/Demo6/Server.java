package day21.Socket1.Demo6;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {
        //1. 创建Socket对象
        ServerSocket ss = new ServerSocket(10001);
        //2. 等待客户端连接
        //监听客户端连接，返回一个socket对象
        System.out.println(111);
        //accept是阻塞的
        //三次握手建立连接
        Socket accept = ss.accept();
        System.out.println(222);
        //3.获得输入流对象
        //字节输入流
        InputStream is = accept.getInputStream();
        int b;
        //read也是阻塞的
        while((b = is.read()) != -1){
            System.out.print((char) b);
        }

        System.out.println("看看我执行了吗?");

        //4.释放资源
        is.close();
        //四次挥手释放连接
        ss.close();
    }
}
