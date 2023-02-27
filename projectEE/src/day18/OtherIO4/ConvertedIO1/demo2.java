package day18.OtherIO4.ConvertedIO1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
public class demo2 {
    public static void main(String[] args) throws IOException {
        User user = new User("zhangsan","qwer");
        //需求:把这个用户信息保存到本地文件去.
        //这样实现并不安全，任何人都可以读取该文件，因此我们可以使用对象操作流，将对象以字节的形式写到本地文件，直接打开文件是读不懂的，需要再次使用对象操作流读到内存中
        BufferedWriter bw = new BufferedWriter(new FileWriter("a.txt"));
        bw.write(user.getUsername());
        bw.newLine();
        bw.write(user.getPassword());
        bw.close();
    }
}
