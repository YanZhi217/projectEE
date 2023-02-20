package day14.JDK8Date2;

import java.time.LocalDateTime;
public class demo6 {
    /*
        JDK8 时间类添加或者减去时间的方法
        plusYears()
        plusMonths()
        plusDays()
        plusHours()
        plusMinutes()
        plusSeconds()
        plusWeeks()
     */
        public static void main(String[] args) {
            //public LocalDateTime plusYears (long years)   添加或者减去年

            LocalDateTime localDateTime = LocalDateTime.of(2020, 11, 11, 13, 14, 15);
            //LocalDateTime newLocalDateTime = localDateTime.plusYears(1);
            //System.out.println(newLocalDateTime);

            LocalDateTime newLocalDateTime = localDateTime.plusYears(-1);
            System.out.println(newLocalDateTime);
        }

}
