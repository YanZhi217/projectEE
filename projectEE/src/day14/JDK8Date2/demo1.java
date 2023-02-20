package day14.JDK8Date2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class demo1 {
    public static void main(String[] args) throws ParseException {
        //JDKMethod();

        String s = "2020年11月11日 00:00:00";

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(s, pattern);
        LocalDateTime newLocalDateTime = localDateTime.plusDays(1);
        String result = newLocalDateTime.format(pattern);
        System.out.println(result);

        JDKMethod();
    }

    private static void JDKMethod() throws ParseException {
        String s = "2020年11月11日 00:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = sdf.parse(s);
        long time = date.getTime();
        time = time + (1000 * 60 * 60 * 24);
        Date newDate = new Date(time);
        String result = sdf.format(newDate);
        System.out.println(result);
    }
}
