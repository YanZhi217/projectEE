package day21.OptimizesServer2.ThreadSocket3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
public class Server {
    /*
        使用多线程使服务器可以同时处理多个客户端请求
    */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();
            ThreadSocket ts = new ThreadSocket(accept);
            new Thread(ts).start();

        }
        //ss.close();
    }
}
