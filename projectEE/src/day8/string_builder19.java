package day8;

public class string_builder19 {
    /*
        需求：定义一个方法，把 int 数组中的数据按照指定的格式拼接成一个字符串返回
            调用该方法，并在控制台输出结果。
            例如，数组为int[] arr = {1,2,3};
            执行方法后的输出结果为：[1, 2, 3]

        思路：
            1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
            2. 定义一个方法，返回值类型 String，参数列表 int[] arr
            3. 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
            4. 调用方法，用一个变量接收结果
            5. 输出结果
    */
    public static void main(String[] args) {
        // 1. 定义一个 int 类型的数组，用静态初始化完成数组元素的初始化
        int[] arr = {1,2,3};
        // 4. 调用方法，用一个变量接收结果
        String s = arrayToString(arr);
        // 5. 输出结果
        System.out.println(s);
    }

    // 2. 定义一个方法，返回值类型 String，参数列表 int[] arr
    public static String arrayToString(int[] arr){
        // 3. 在方法中用 StringBuilder 按照要求进行拼接，并把结果转成 String 返回
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length -1){
                sb.append(arr[i]).append("]");
            }else{
                sb.append(arr[i]).append(", ");
            }
        }

        return sb.toString();
    }
}
