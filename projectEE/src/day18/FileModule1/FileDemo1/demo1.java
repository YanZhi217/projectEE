package day18.FileModule1.FileDemo1;

import java.io.File;
public class demo1 {
    public static void main(String[] args) {
        method1();
        method2();
        method3();


    }

    private static void method3() {
        //File(File parent, String child)      从父抽象路径名和子路径名字符串创建新的File实例
        File file1 = new File("D:\\develop\\projectEE\\src");
        String path = "\\day18\\File1\\FileModule1\\FileDemo1\\a.txt";
        File file = new File(file1,path);
        System.out.println(file);//D:\develop\projectEE\src\day18\File1\FileModule1\FileDemo1
    }

    private static void method2() {
        //File(String parent, String child)    从父路径名字符串和子路径名字符串创建新的File实例
        String path1 = "D:\\develop\\projectEE\\src";
        String path2 = "\\day18\\File1\\FileModule1\\FileDemo1\\a.txt";
        File file = new File(path1,path2);//把两个路径拼接.
        System.out.println(file);//D:\develop\projectEE\src\day18\File1\FileModule1\FileDemo1
    }

    private static void method1() {
        //File(String pathname)        通过将给定的路径名字符串转换为抽象路径名来创建新的File实例
        String path = "D:\\develop\\projectEE\\src\\day18\\File1\\FileModule1\\FileDemo1\\a.txt";
        File file = new File(path);
        System.out.println(file);//D:\develop\projectEE\src\day18\File1\FileModule1\FileDemo1
        //问题:为什么要把字符串表示形式的路径变成File对象?
        //就是为了使用File类里面的方法.
    }

}
