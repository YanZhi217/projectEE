package day21.Socket1.Demo8;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    /*
        服务器端
        接收到的数据写入本地文件，给出反馈
    */
    public static void main(String[] args) throws IOException {
            ServerSocket ss = new ServerSocket(10001);

            //建立连接
            Socket accept = ss.accept();

            //网络中的流,从客户端读取数据的
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            //本地的IO流,把数据写到本地中,实现永久化存储
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("C:\\Users\\YanZhi\\Desktop\\3.pdf"));

            int b;
            while((b = bis.read()) !=-1){
                bos.write(b);
            }

            //网络中的流，反馈给客户端数据
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();

            bos.close();
            accept.close();
            ss.close();

    }
}
