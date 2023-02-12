package day7;

public class text_phone4 {
    public static void main(String[] args) {
        // 1. 创建对象
        phone3 p = new phone3();
        // 2. 给成员变量进行赋值
        p.brand = "大米";
        p.price = 2999;
        // 3. 打印赋值后的成员变量
        System.out.println(p.brand + "..." + p.price);
        // 4. 调用成员方法
        p.call("阿强");
        p.sendMessage();
    }
}
