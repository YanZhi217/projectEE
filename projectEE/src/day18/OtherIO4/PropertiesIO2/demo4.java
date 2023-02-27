package day18.OtherIO4.PropertiesIO2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
public class demo4 {
    public static void main(String[] args) throws IOException {
        //void load(Reader reader)                     将本地文件中的键值对数据读取到集合中
        //void store(Writer writer, String comments)   将集合中的数据以键值对形式保存在本地


        Properties prop = new Properties();
        prop.put("zhangsan","123");
        prop.put("lisi","456");
        prop.put("wangwu","789");

        //代表本模块下的prop.properties文件
        FileWriter fw = new FileWriter("prop.properties");

        //第二个参数代表注释
        prop.store(fw,null);
        fw.close();


    }
}
