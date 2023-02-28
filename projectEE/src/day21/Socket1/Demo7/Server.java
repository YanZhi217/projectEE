package day21.Socket1.Demo7;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10000);

        Socket accept = ss.accept();

        InputStream is = accept.getInputStream();
        int b;
        while((b = is.read())!=-1){
            System.out.println((char) b);
        }

        System.out.println("看看我执行了吗?");
       /* OutputStream os = accept.getOutputStream();
        os.write("你谁啊?".getBytes());*/
        //使用OutputStreamWriter()转换流使字符流转换为accept.getOutStream()字节流，OutputStreamWriter()是字符流转换为字节流的桥梁
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("你谁啊?");
        bw.newLine();
        bw.flush();

        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}
