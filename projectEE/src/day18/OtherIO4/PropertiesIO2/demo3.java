package day18.OtherIO4.PropertiesIO2;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class demo3 {
    public static void main(String[] args) throws IOException {
        //void load(Reader reader)                     将本地文件中的键值对数据读取到集合中
        //void store(Writer writer, String comments)   将集合中的数据以键值对形式保存在本地

        //properties需要存储在properties后缀名的文件中


        //读取
        Properties prop = new Properties();
        FileReader fr = new FileReader("D:\\develop\\projectEE\\prop.properties");
        //调用完了load方法之后,文件中的键值对数据已经在集合中了.
        prop.load(fr);
        fr.close();

        System.out.println(prop);
    }


}
