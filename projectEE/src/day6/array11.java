package day6;

public class array11 {
    /*
        需求:
            某公司季度和月份统计的数据如下：单位(万元)
            第一 季度：22,66,44
            第二 季度：77,33,88
            第三 季度：25,45,65
            第四 季度：11,66,99

        步骤:
            1. 定义求和变量，准备记录最终累加结果
            2. 使用二维数组来存储数据，每个季度是一个一维数组，再将4个一维数组装起来
            3. 遍历二维数组，获取所有元素，累加求和
            4. 输出最终结果
    */
    public static void main(String[] args) {
        // 1. 定义求和变量，准备记录最终累加结果
        int sum = 0;
        // 2. 使用二维数组来存储数据，每个季度是一个一维数组，再将4个一维数组装起来
        int[][] arr = { {22,66,44} , {77,33,88} , {25,45,65} , {11,66,99}};
        // 3. 遍历二维数组，获取所有元素，累加求和
        for (int[] ints : arr) {         //for (int i = 0; i < arr.length; i++)
            for (int anInt : ints) {     //for (int j = 0; j < arr[i].length; j++)
                sum += anInt;
            }
        }
        // 4. 输出最终结果
        System.out.println(sum);
    }
}
