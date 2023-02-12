package day2;

public class operator7 {
        /*
		    关系运算符(比较运算符) :
			    (>)	(>=) (<) (<=) (==) (!=)
	    */
    public static void main(String[] args){
        System.out.println(10 > 20);	// false
        System.out.println(10 >= 20);	// false
        System.out.println(10 < 20);	// true
        System.out.println(10 <= 20);	// true
        System.out.println(10 == 20);	// false
        System.out.println(10 != 20);	// true

        /*
		    逻辑运算符作用: 用于[整合]多个比较表达式的条件
			    1. 连接多个比较表达式
			    2. 连接true或false
		    最终得到的结果都是boolean类型的true或false.
		    应用场景:
				       需求: 键盘录入学生成绩, 如果是90-100之间, 程序输出[优秀]
						判断条件(score >= 90 & score <= 100)
				    需求: 键盘录入工人工号, 只要3号或者5号或者7号.
						判断条件(id == 3 | id == 5 | id == 7)
	    */
        int x = 10;
        // true & true
        // x > 5 并且 x < 15
        System.out.println(x > 5 & x < 15);	// true

        /*
		    逻辑运算符分类 :
			    &(与) : 并且, 遇false则false, 只有符号左右两边同时为true, 结果才为true.
			    |(或) : 或者, 遇true则true, 只有符号左边两边同时为false, 结果才为false
			    !(非) : 取反
			    ^(异或) : 相同为false, 不同为true.
	    */

        // &(与) : 并且
        System.out.println(true & true);		// true
        System.out.println(false & false);		// false
        System.out.println(true & false);		// false
        System.out.println(false & true);		// false
        System.out.println("------------------");
        // |(或) : 或者
        System.out.println(true | true);		// true
        System.out.println(false | false);		// false
        System.out.println(true | false);		// true
        System.out.println(false | true);		// true
        System.out.println("------------------");
        // !(非) : 取反
        System.out.println(!true);				// false
        System.out.println(!!true);				// true
        System.out.println("------------------");
        // ^(异或) :
        System.out.println(true ^ true);		// false
        System.out.println(false ^ false);		// false
        System.out.println(true ^ false);		// true
        System.out.println(false ^ true);		// true

        /*
		    & 和 && 的区别 :
			    & : 无论符号左边是true还是false, 右边都要继续执行
			    && : 具有短路效果, 符号左边为false的时候, 右边就不执行了.
					如果符号左边为true, 右边要继续执行.
	    */
            int xx = 3;
            int y = 4;
            // false & true
            System.out.println(++xx > 4 && y-- < 5);	// false
            System.out.println("x=" + xx);	// 4
            System.out.println("y=" + y);	// 4
    }
}
