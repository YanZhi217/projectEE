package day18.FileModule1.FileDemo1;

import java.io.File;
public class demo6 {
    public static void main(String[] args) {

        File file = new File("D:\\aaa");
        File[] files = file.listFiles();//返回值是一个File类型的数组
        System.out.println(files.length);
        for (File path : files) {
            System.out.println(path);
        }

        //进入文件夹,获取这个文件夹里面所有的文件和文件夹的File对象,并把这些File对象都放在一个数组中返回.
        //包括隐藏文件和隐藏文件夹都可以获取.

        //注意事项:
        //1.当调用者是一个文件时,返回null
        //2,当调用者是一个空文件夹时，返回长度为0的数组
        //3.当调用者是一个有内容的文件夹时，将里面所有文件和文件夹的路径放在File数组里返回
        //4.当调用者是一个有权限才能进入的文件夹时，返回null
        //5.当调用这是一个有隐藏文件的文件夹时，将里面所有的文件和文件夹的路径放在File数组中返回，包括隐藏内容
        //6.当调用者不存在时,返回null
    }
}
