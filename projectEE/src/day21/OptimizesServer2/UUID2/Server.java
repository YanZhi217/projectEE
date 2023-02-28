package day21.OptimizesServer2.UUID2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class Server {
    /*
        加入UUID，使每次客户端传送过来的数据都能单独保存在一个文件中而不是覆盖以前的文件
    */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();

            //网络中的流,从客户端读取数据的
            BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
            //本地的IO流,把数据写到本地中,实现永久化存储
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream("C:\\Users\\YanZhi\\Desktop\\" + UUID.randomUUID() + ".pdf"));

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();

            bos.close();
            accept.close();
        }
        //ss.close();


    }
}
