package day21.Socket1.Demo5;


import java.io.IOException;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = "广播 Hello";
        byte[] bytes = s.getBytes();
        //255.255.255.255表示广播地址
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes ,bytes.length ,address ,port);

        ds.send(dp);

        ds.close();
    }
}
