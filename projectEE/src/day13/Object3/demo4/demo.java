package day13.Object3.demo4;

import java.util.Objects;

public class demo {
    public static void main(String[] args) {
//        public static String toString(对象)  		 返回参数中对象的字符串表示形式。
        Student s1 = new Student("小罗同学",50);
        String result1 = Objects.toString(s1);
        System.out.println(result1);
        System.out.println(s1);


//        public static String toString(对象, 默认字符串)  返回对象的字符串表示形式。如果对象为空,那么返回第二个参数.
        Student s2 = new Student("小花同学",23);
        Student s3 = null;
        String result2 = Objects.toString(s2, "随便写一个");
        String result3 = Objects.toString(s3, "随便写一个");
        System.out.println(result2);
        System.out.println(result3);

//        public static Boolean isNull(对象)		 判断对象是否为空
        Student s4 = null;
        Student s5 = new Student();
        boolean result4 = Objects.isNull(s4);
        boolean result5 = Objects.isNull(s5);
        System.out.println(result4);
        System.out.println(result5);


//        public static Boolean nonNull(对象)		 判断对象是否不为空
        Student s6 = new Student();
        Student s7 = null;
        boolean result6 = Objects.nonNull(s6);
        boolean result7 = Objects.nonNull(s7);
        System.out.println(result6);
        System.out.println(result7);

    }
}
