package day3;

public class for7 {
    /*
		需求：求1-100之间的偶数和，并把求和结果在控制台输出
		分析:
			1. 需求是要求和, 定义求和变量.
			2. 循环中获取1-100之间的每一个数值
			3. 循环的过程中，对每一个数值进行if判断, 判断是否是偶数
			4. 是偶数的话, 跟求和变量累加
			5. 循环结束后, 打印最终结果
	*/
    public static void main(String[] args) {
        // 1. 需求是要求和, 定义求和变量.
        int sum = 0;
        // 2. 循环中获取1-100之间的每一个数值
        for(int i = 1; i <= 100; i++){
            // 3. 循环的过程中，对每一个数值进行if判断, 判断是否是偶数
            if(i % 2 == 0){
                // 4. 是偶数的话, 跟求和变量累加
                sum += i;
            }
        }

        // 5. 循环结束后, 打印最终结果
        System.out.println("1-100之间的偶数和为:" + sum);
    }
}