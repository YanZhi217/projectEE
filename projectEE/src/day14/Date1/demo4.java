package day14.Date1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo4 {
    public static void main(String[] args) throws ParseException {
        String s = "2048-01-01";

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        //时间日期格式需要和字符串格式保持一致
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = sdf.parse(s);

        String a = sdf.format(date);
        System.out.println(date);
        System.out.println(a);
    }
}
