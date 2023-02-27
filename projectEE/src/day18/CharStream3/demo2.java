package day18.CharStream3;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
/**
* 常见的字符集有，ASCII、GBXXX、Unicode编码表
* ASCII，一个字符一个字节
* GBX，最常用的中文码表，一个字符两个字节
* Unicode，万国编码表，一个字符一到四个字节
 * UTF-8是一种编码规范，不存在编码表
 * 不管在哪张码表中，中文的第一个字节一定是负数
*/
public class demo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //method1();

        // String(byte[] bytes)：
        //通过使用平台的默认字符集解码指定的字节数组来构造新的 String
        // String(byte[] bytes, String charsetName)：
        //通过指定的字符集解码指定的字节数组来构造新的 String

        //UTF-8
        byte [] bytes1 = {-28, -67, -96, -27, -91, -67, -28, -72, -106, -25, -107, -116, 33};
        //gbk
        byte [] bytes2 = {-60, -29, -70, -61, -54, -64, -67, -25, 33};

        //利用默认的UTF-8进行解码
        String s1 = new String(bytes1);
        System.out.println(s1);//你好世界!

        //利用指定的GBK进行解码
        String s2 = new String(bytes2,"gbk");
        System.out.println(s2);//你好世界!

    }

    private static void method1() throws UnsupportedEncodingException {
        // byte[] getBytes()：
        //使用平台的默认字符集将该 String编码为一系列字节，将结果存储到新的字节数组中
        // byte[] getBytes(String charsetName)：
        //使用指定的字符集将该 String编码为一系列字节，将结果存储到新的字节数组中

        String s = "你好世界!";
        //利用idea默认的UTF-8将中文编码为一系列的字节，一个中文第三个字节
        byte[] bytes1 = s.getBytes();
        System.out.println(Arrays.toString(bytes1));

        //byte[] bytes2 = s.getBytes("UTF-8");
        byte[] bytes2 = s.getBytes("GBK");
        System.out.println(Arrays.toString(bytes2));
    }
}
