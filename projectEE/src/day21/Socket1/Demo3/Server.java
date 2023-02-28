package day21.Socket1.Demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        //如果接收端在建立连接的时候没有指定端口，将会随机动态端口来接收
        DatagramSocket ds = new DatagramSocket(10000);

        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            System.out.println(new String(data,0,length));
        }

        //ds.close();
    }


}