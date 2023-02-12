package day8;

public class string_builder17 {
    /*
        成员方法:
              public StringBuilder append(任意类型) : 添加数据，并返回对象本身
              public StringBuilder reverse() : 返回相反的字符序列
              public int length() : 返回长度 (字符出现的个数)
              public String toString() : 通过toString()就可以实现把StringBuilder转换为String
    */
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        //sb.append("红色");
        //System.out.println(sb);
        //sb.append("蓝色");
        //System.out.println(sb);
        //sb.append("绿色");
        //System.out.println(sb);

        //StringBuilder sb2 = sb.append("红色");
        //StringBuilder sb3 = sb2.append("蓝色");
        //sb3.append("绿色");

        // 链式编程: 如果一个方法返回的是对象类型, 对象就可以继续向下调用方法.
        sb.append("红色").append("蓝色").append("绿色");

        System.out.println("反转前:" + sb);
        sb.reverse();
        System.out.println("反转后:" + sb);

        System.out.println("sb中字符的个数为:" + sb.length());

        // public String toString() : 通过toString()就可以实现把StringBuilder转换为String
        String s = sb.toString();
        System.out.println(s);
    }
}
