package day8;
import java.util.Scanner;
public class text8 {
    /*
       需求：键盘录入一个字符串，使用程序实现在控制台遍历该字符串
       思路：
       1. 键盘录入一个字符串，用 Scanner 实现
       2. 将字符串拆分为字符数组
                public char[] toCharArray( )：将当前字符串拆分为字符数组并返回
       3. 遍历字符数组
    */
    public static void main(String[] args) {
        //  1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入:");
        String s = sc.nextLine();
        // 2. 将字符串拆分为字符数组
        char[] chars = s.toCharArray();
        // 3. 遍历字符数组
        for (char aChar : chars) {      //for(int i = 0; i < chars.length; i++)
            System.out.println(aChar);  //System.out.println(char[i])
        }
    }
}
