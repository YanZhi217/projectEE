package day14.JDK8Date2;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
public class demo4 {
    public static void main(String[] args) {
        //LocalDateTime localDateTime = LocalDateTime.of(2020, 12, 12, 8, 10, 12);
        LocalDateTime localDateTime = LocalDateTime.now();

        //public LocalDate toLocalDate ()    转换成为一个LocalDate对象
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        //public LocalTime toLocalTime ()    转换成为一个LocalTime对象
        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);

    }
}
