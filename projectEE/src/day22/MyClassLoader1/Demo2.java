package day22.MyClassLoader1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        //static ClassLoader getSystemClassLoader() 获取系统类加载器
        //InputStream getResourceAsStream(String name)  加载某一个资源文件

        //获取系统类加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();

        //利用加载器去加载一个指定的文件
        //参数：文件的路径
        //类加载器中的相对路径指的是src这个文件夹下边的文件，而不是模块下的
        //返回值：字节流。
        //Properties类 继承于 Hashtable。表示一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
        //此类是线程安全的
        InputStream is = systemClassLoader.getResourceAsStream("prop.properties");

        Properties prop = new Properties();
        //将字节输入流中的数据读到集合当中
        prop.load(is);

        System.out.println(prop);

        if (is != null) {
            is.close();
        }
    }
}
