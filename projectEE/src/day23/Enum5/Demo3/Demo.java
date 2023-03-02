package day23.Enum5.Demo3;

public class Demo {
    public static void main(String[] args) {
//        String name() 获取枚举项的名称
        String name1 = Season.SPRING.name();
        String name2 = Season.SUMMER.name();
        System.out.println(name1);
        System.out.println(name2);
        System.out.println("-----------------------------");

//        int ordinal() 返回枚举项在枚举类中的索引值
        int index1 = Season.SPRING.ordinal();
        int index2 = Season.SUMMER.ordinal();
        int index3 = Season.AUTUMN.ordinal();
        int index4 = Season.WINTER.ordinal();
        int index5 = Season.SPRING.ordinal();
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);
        System.out.println(index5);
        System.out.println("-----------------------------");

//        int compareTo(E o) 比较两个枚举项，返回的是索引值的差值
        int result1 = Season.SPRING.compareTo(Season.WINTER);
        int result2 = Season.SUMMER.compareTo(Season.SPRING);
        System.out.println(result1);//-3
        System.out.println(result2);
        System.out.println("-----------------------------");

//        String toString()   返回枚举常量的名称
        //一般用name()方法，toString一般用在打印输出
        String s1 = Season.SPRING.toString();
        String s2 = Season.SUMMER.toString();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("-----------------------------");

//        static <T> T valueOf(Class<T> type,String name)
//        获取指定枚举类中的指定名称的枚举值
        Season spring1 = Enum.valueOf(Season.class, "SPRING");
        Season spring2 = Enum.valueOf(Season.class, "SUMMER");
        System.out.println(spring1);
        System.out.println(spring2);
        System.out.println(Season.SPRING == spring1);
        System.out.println(Season.SUMMER == spring2);
        System.out.println("-----------------------------");

//        values()       获得所有的枚举项
        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }


    }
}