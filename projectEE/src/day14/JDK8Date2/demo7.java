package day14.JDK8Date2;

import java.time.LocalDateTime;
public class demo7 {
    /*
        JDK8 时间类减少或者添加时间的方法
        minusYears()
        minusMonths()
        minusDays()
        minusHours()
        minusMinutes()
        minusSeconds()
        minusWeeks()
     */
    public static void main(String[] args) {
        //public LocalDateTime minusYears (long years)  减去或者添加年
        LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
        //LocalDateTime newLocalDateTime = localDateTime.minusYears(1);
        //System.out.println(newLocalDateTime);

        LocalDateTime newLocalDateTime = localDateTime.minusYears(-1);
        System.out.println(newLocalDateTime);

    }
}
