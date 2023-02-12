package day2;

public class operator3 {
        /*
            运算符:
                对[常量]或[变量]进行操作的符号
            算数运算符
                + - * : 跟小学数学的运算方式一样
                / : 整数相除,结果只能得到整数,如果想要得到带有小数的结果,必须加入小数(浮点类型)的运算
                %(取模) : 取余数
        */
        public static void main(String[] args){
            System.out.println(10 + 20);
            System.out.println(10 - 20);
            System.out.println(10 * 20);
            System.out.println("-----------------------");
		/*
			/ : 整数相除,结果只能得到整数,如果想要得到带有小数的结果,必须加入小数(浮点类型)的运算
		*/
            System.out.println(10 / 2);		// 5
            System.out.println(10 / 3);		// 3
            System.out.println(10 / 3.0);		// 3.3333333333333335
            System.out.println(10.0 / 3);		// 3.3333333333333335
            System.out.println("-----------------------");
		/*
			%(取模) : 取余数
		*/
            System.out.println(5 % 2);		// 5 / 2 = 商2, 余数为1
            System.out.println("-----------------------");
            /*
		        字符串的 + 操作
			    当 + 操作中出现字符串时，这个 + 是[字符串连接符]，而不是算术运算。
	        */
                // 字符串可以使用 +号, 跟[任意数据类型]拼接
                System.out.println("itheima" + 666);
                System.out.println("itheima" + true);

                System.out.println(1 + 99 + "年黑马");
                System.out.println("5+5="+5+5);				// 5+5=55
                System.out.println("5+5="+(5+5));			// 5+5=10
                System.out.println("-----------------------");
            /*
		        自增自减运算符 :
			    ++ : 变量自身+1
			    -- : 变量自身-1
			    ++ 和-- 既可以放在变量的后边，也可以放在变量的前边。
		        注意:
			    单独使用的时候， ++和-- 无论是放在变量的前边还是后边，结果是一样的
	        */
                int a = 10;
                ++a;						// a = a + 1;
                System.out.println(a);		// 11
                int b = 10;
                --b;
                System.out.println(b);		// 9
        }
}
