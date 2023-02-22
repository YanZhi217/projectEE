package day16.Set1.TreeSet2;

import java.util.TreeSet;
public class demo5 {
    public static void main(String[] args) {
        //比较器排序
//        TreeSet<String> ts = new TreeSet<>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int result = o1.length() - o2.length();
//                result = result == 0 ? o1.compareTo(o2) : result;
//                return result;
//            }
//        });

        //lambda表达式
        TreeSet<String> ts = new TreeSet<>(
                (String o1, String o2) -> {
                    int result = o1.length() - o2.length();
                    result = result == 0 ? o1.compareTo(o2) : result;
                    return result;
                }
        );

        ts.add("c");
        ts.add("ab");
        ts.add("df");
        ts.add("qwer");


        System.out.println(ts);
    }
}
