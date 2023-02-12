package day8;
import java.util.Scanner;
public class string_equals5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        //sc.nextLine();
        String s2 = sc.nextLine();
        //sc.nextLine();
        String s3 = sc.nextLine();

        // equals : 比较字符串内容, 区分大小写
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));

        // equalsIgnoreCase : 比较字符串内容, 忽略大小写
        System.out.println(s1.equalsIgnoreCase(s2));
    }
}
