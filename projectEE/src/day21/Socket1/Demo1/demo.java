package day21.Socket1.Demo1;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class demo {
    /*
        网络编程三要素
            IP地址，端口，协议(TCP,UDP)

        127.0.0.1，本地环回地址，可代表本机的IP地址，一般用来测试使用
    */
    //static InetAddress getByName(String host)     确定主机名称的IP地址。主机名称可以是机器名称，也可以是IP地址
    //String getHostName()     获取此IP地址的主机名
    //String getHostAddress()  返回文本显示中的IP地址字符串

    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("YanZhi");

        String hostName = address.getHostName();
        System.out.println("主机名为" + hostName);

        String ip = address.getHostAddress();
        System.out.println("IP为" + ip);
    }
}