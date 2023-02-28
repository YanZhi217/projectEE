package day21.Socket1.Demo5;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Server {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10000);

        DatagramPacket dp = new DatagramPacket(new byte[1024],1024);
        ds.receive(dp);

        byte[] bytes = dp.getData();
        int length = dp.getLength();
        System.out.println(new String(bytes,0,length));

        ds.close();
    }
}
