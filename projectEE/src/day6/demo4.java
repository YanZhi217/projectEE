package day6;

public class demo4 {
    /*
        ^ 运算符的特点

                一个数, 被另外一个数, 异或两次, 该数本身不变
    */
    public static void main(String[] args) {
        System.out.println(10 ^ 5 ^ 10);

            int a = 10;
            int b = 20;

            a = a ^ b;
            b = a ^ b;
            a = a ^ b;

            System.out.println("a=" + a);
            System.out.println("b=" + b);
    }
}
