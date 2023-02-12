package day8;

import java.util.Scanner;

public class string_builder18 {
    /*
        需求：键盘接受一个字符串，程序判断出该字符串是否是对称字符串，并在控制台打印是或不是
            对称字符串：123321、111
            非对称字符串：123123
        思路：
            1. 键盘录入一个字符串，用 Scanner 实现
            2. 将键盘录入的字符串反转
            3. 使用反转后的字符串，和原字符串进行比对
            4. 如果相同，则输出是对称字符串，反之输出不是对称字符串

    */
    public static void main(String[] args) {
        //  1. 键盘录入一个字符串，用 Scanner 实现
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入对称字符串:");
        String s = sc.nextLine();

        // 2. 将键盘录入的字符串反转
        // 将字符串封装为StringBuilder对象, 目的是为了掉用其反转的方法
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        String reverseStr = sb.toString();

        // s : String
        // sb : StringBuilder
        // 3. 使用反转后的字符串，和原字符串进行比对
        if(s.equals(reverseStr)){
            System.out.println("是对称字符串");
        }else{
            System.out.println("不是对称字符串");
        }
    }
}
