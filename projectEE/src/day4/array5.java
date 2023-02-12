package day4;

public class array5 {
    /*
    寄存器给CPU使用，与开发无关
    本地方法栈JVM在使用操作系统功能的时候使用，与开发无关
    方法区存储可以运行的class文件
    堆内存存储对象或者数组，new来创建的都在堆内存
    方法栈存储方法，例如main方法
    */
    public static void main(String[] args) {
        int[] arr1 = new int[2];
        System.out.println(arr1);
        arr1[0] = 11;
        arr1[1] = 22;
        System.out.println(arr1[0]);
        System.out.println(arr1[1]);

        System.out.println("-------------");

        int[] arr2 = new int[3];
        System.out.println(arr2);
        arr2[0] = 33;
        arr2[1] = 44;
        arr2[2] = 55;
        System.out.println(arr2[0]);
        System.out.println(arr2[1]);
        System.out.println(arr2[2]);
    }
}
