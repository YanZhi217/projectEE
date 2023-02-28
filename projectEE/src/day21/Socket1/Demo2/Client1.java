package day21.Socket1.Demo2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client1 {
    /*
        端口号的取值范围0 ~ 65535
        0 ~ 1023用于一些知名的网络服务或应用
        我们通常使用1024以上的
        一个端口号只能用在一个应用程序上
    */

    //发送端

    public static void main(String[] args) throws IOException {
        //1.找码头
        DatagramSocket ds = new DatagramSocket();
        //2.打包礼物
        //DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        //              要发送的数据 , 发送的长度  ,      接收的地址      , 接收的端口号
        String s = "送给村长老丈人的礼物";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);


        //3.由码头发送包裹
        ds.send(dp);

        //4.付钱走羊
        ds.close();
    }
}
