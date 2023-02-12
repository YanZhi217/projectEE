package day2;

public class operator6 {
    /*
		基本赋值运算符:
			= : 将符号右侧的数据, 赋值给左边
		扩展赋值运算符:
			+=  -=  *=  /=  %=
			+= : 将符号左右两边的数据, 做加法运算, 结果赋值给左边
	*/
    public static void main(String[] args) {
        int a = 10;
        // += : 将符号左右两边的数据, 做加法运算, 结果赋值给左边
        a += 20;
        System.out.println(a);

    /*
		阅读下列代码, 查看是否存在问题, 如果有请指出并修正
	*/
        short s = 1;
        // s是short类型, 1默认是int类型
        // short和int相加, short会先提升为int, 然后再进行运算
        // 提升之后, 就是两int相加, 两个int相加, 结果还是int, 将int赋值给short
        // 需要加入强转.
        // s = s + 1;		//  错误: 不兼容的类型: 从int转换到short可能会有损失
        s = (short) (s + 1);
        System.out.println(s);

        short ss = 1;
        ss += 1;        // ss = (short)(ss + 1);
        // 注意: 扩展赋值运算符底层会自带强转功能
        System.out.println(ss);
    }
}
