package day5;

public class method4 {
    /*
        需求：设计一个方法可以获取两个数的较大值，数据来自参数

        1. 定义一个方法，声明两个形参接收计算的数值，求出结果并返回
        2. 使用 if 语句 得出 a 和 b 之间的最大值，根据情况return具体结果
        3. 在main()方法中调用定义好的方法并使用 【 变量保存 】

        public static 返回值类型 方法名(参数) {
            方法体;
            return 数据 ;
        }
        public static 修饰符，目前先记住这个格式
        返回值类型 方法操作完毕之后返回的数据的数据类型
        如果方法操作完毕，没有数据返回，这里写void，而且方法体中一般不写return
        方法名 调用方法时候使用的标识
        参数 由数据类型和变量名组成，多个参数之间用逗号隔开
        方法体 完成功能的代码块
        return 如果方法操作完毕，有数据返回，用于把数据返回给调用者
     */
    public static void main(String[] args) {
        // 3. 在main()方法中调用定义好的方法并使用 【 变量保存 】
        System.out.println(getMax(10,20));  // 输出调用

        int result = getMax(10,20);
        System.out.println(result);

        for(int i = 1; i <= result; i++){
            System.out.println("HelloWorld");
        }

    }

    // 方法可以获取两个数的较大值
    public static int getMax(int a, int b){
        return Math.max(a, b);
    }


}
