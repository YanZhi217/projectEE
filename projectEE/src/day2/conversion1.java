package day2;

public class conversion1 {
        /*
            隐式转换: 将数据类型中, 取值范围小的数据, 给取值范围大的类型赋值, 可以直接赋值
		    强制转换: 把一个表示数据范围大的数值或者变量赋值给另一个表示数据范围小的变量
		    简答理解: 大的给小的, 不能直接给, 需要强转
		    格式：目标数据类型 变量名 = (目标数据类型)值或者变量;
	    */
        public static void main(String[] args) {
            int a = 10;			// int 4个字节
            double b = a;		// double 8个字节
            System.out.println(b); //10.0

            int c = 10;				// int 4个字节
            byte d = (byte)c;		// byte 1个字节		错误: 不兼容的类型: 从int转换到byte可能会有损失精度
            System.out.println(d);

            double num1 = 12.9;
            int num2 = (int)num1;
            System.out.println(num2);
        }
}
