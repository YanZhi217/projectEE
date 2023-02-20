package day14.JDK8Date2;

import java.time.LocalDate;
import java.time.Period;

public class demo9 {
    /*
        计算两个时间的间隔
     */
    public static void main(String[] args) {
        /*
        public static Period between(开始时间,结束时间)  计算两个"时间"的间隔
        getYears()
        getMonths()
        getDays()
        toTotalMonths()
         */


        LocalDate localDate1 = LocalDate.of(2020, 1, 1);
        LocalDate localDate2 = LocalDate.of(2048, 12, 12);
        Period period = Period.between(localDate1, localDate2);
        System.out.println(period);//P28Y11M11D

        //public int getYears()         获得这段时间的年数
        System.out.println(period.getYears());//28
        //public int getMonths()        获得此期间的月数
        System.out.println(period.getMonths());//11
        //public int getDays()          获得此期间的天数
        System.out.println(period.getDays());//11

        //public long toTotalMonths()   获取此期间的总月数
        System.out.println(period.toTotalMonths());//347

    }
}
