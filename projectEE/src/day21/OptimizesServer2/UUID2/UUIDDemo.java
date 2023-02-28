package day21.OptimizesServer2.UUID2;

import java.util.UUID;
public class UUIDDemo {
    /*
        UUID用于生成一个不可变的通用唯一标识符
    */
    public static void main(String[] args) {
        //生成一个随机的UUID
        UUID uuid = UUID.randomUUID();
        //将生成的标识符中的“-”替换为“”(空)
        String s = uuid.toString().replace("-","");
        System.out.println(s);
    }
}
