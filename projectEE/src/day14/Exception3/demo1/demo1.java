package day14.Exception3.demo1;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class demo1 {
    public static void main(String[] args) throws ParseException {
//        int [] arr = {1,2,3,4,5};
//        System.out.println(arr[10]);//ArrayIndexOutOfBoundsException  运行异常


//        String s = null;
//        System.out.println(s.equals("嘿嘿"));//NullPointerException    编译异常

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        sdf.parse("2048-1月1日");//ParseException
    }
}
