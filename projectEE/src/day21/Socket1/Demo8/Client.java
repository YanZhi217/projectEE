package day21.Socket1.Demo8;

import java.io.*;
import java.net.Socket;

public class Client {
    /*
        客户端
        数据来自本地文件，读取本地文件，写到服务器
        接收服务器的反馈
    */
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);
        //是本地的流,用来读取本地文件的.
        //字节输入缓冲流，指向本地文件
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\Users\\YanZhi\\Desktop\\1.pdf"));

        //写到服务器 --- 网络中的流
        //OutputStream os = socket.getOutputStream();
        //字节输出缓冲流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);//通过网络写到服务器中
        }
        bos.flush();
        //给服务器一个结束标记,告诉服务器文件已经传输完毕
        socket.shutdownOutput();


        //接收服务器的反馈 -- 网络中的流
        //转换流将字节输入流转换为字符输入缓冲流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        //关闭本地的流
        bis.close();
        //关闭网络连接
        socket.close();

    }
}
