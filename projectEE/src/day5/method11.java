package day5;

import java.util.Scanner;

public class method11 {
    /*
        需求：设计一个方法，该方法能够同时获取数组的最大值，和最小值
        注意: return语句, 只能带回一个结果.
     */
    public static void main(String[] args) {

        int[] arr = {11, 55, 33, 22, 44};
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("请输入第"+(i+1)+"个数");
            arr[i] = sc.nextInt();
        }

        int[] maxAndMin = getMaxAndMin(arr);

        System.out.println("最小值为"+maxAndMin[0]);
        System.out.println("最大值为"+maxAndMin[1]);

    }

    public static int[] getMaxAndMin(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return new int[]{min, max};
    }
}
