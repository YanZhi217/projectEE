package day5;

import java.util.Scanner;

public class method2 {
    /*
        需求：设计一个方法method，方法中定义一个变量(数值随意)
        判断这个变量是奇数还是偶数，并在main方法中调用method。

        1. 定义method方法
        2. 方法中定义变量, 使用if语句判断是奇数还是偶数
        3. main方法中调用method

        带参数方法的定义格式:
                public static void 方法名  ( 参数 )  { … … }
                public static void 方法名  ( 数据类型 变量名 )  { … … }

        带参数方法的调用格式:
                方法名 ( 参数 ) ;
                方法名 ( 变量名/常量值 ) ;

        tips: 参数可以是一个, 也可以是多个.

        需求: 判断一个数是奇数还是偶数
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入想要的数字：");
        int num = sc.nextInt();
        // 3. main方法中调用method
        method(num);
    }

    // 1. 定义method方法
    public static void method(int num){
        //  2. 方法中定义变量, 使用if语句判断是奇数还是偶数

        if(num % 2 == 0){
            System.out.println("这个数是偶数");
        }else{
            System.out.println("这个数是奇数");
        }
    }
}
