package day21.Socket1.Demo4;


import java.io.IOException;
import java.net.*;
/*
* 组播
* 范围在224.0.0.0 ~ 239.255.255.255
* 但是224.0.0.0 ~ c224.0.0.255是预留地址
* 所以能用的要从224.0.1.0开始
* */
public class Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        String s = "hello 组播";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        ds.send(dp);

        ds.close();
    }
}