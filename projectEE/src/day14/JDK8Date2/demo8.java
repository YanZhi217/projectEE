package day14.JDK8Date2;

import java.time.LocalDateTime;
public class demo8 {
    /*
        JDK8 时间类修改时间
        withYear()
        withMonth()
        withDayOfMonth()
        withDayOfYear()
        withHour()
        withMinute()
        withSecond()
     */
    public static void main(String[] args) {
        //public LocalDateTime withYear(int year)   修改年
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
        LocalDateTime newLocalDateTime = localDateTime.withYear(2048);
        // System.out.println(newLocalDateTime);

        //LocalDateTime newLocalDateTime = localDateTime.withMonth(20);
        System.out.println(newLocalDateTime);

    }
}
