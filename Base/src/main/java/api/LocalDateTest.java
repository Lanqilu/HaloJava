package api;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Halo
 * @create 2021/10/29 下午 07:08
 * @description
 */
public class LocalDateTest {
    public static void main(String[] args) {
        // 1、获取本地日期对象。
        LocalDate nowDate = LocalDate.now();
        // 今天的日期
        System.out.println("今天的日期：" + nowDate);

        int year = nowDate.getYear();
        System.out.println("year：" + year);


        int month = nowDate.getMonthValue();
        System.out.println("month：" + month);

        int day = nowDate.getDayOfMonth();
        System.out.println("day：" + day);

        // 当年的第几天
        int dayOfYear = nowDate.getDayOfYear();
        System.out.println("dayOfYear：" + dayOfYear);

        // 星期
        System.out.println(nowDate.getDayOfWeek());
        System.out.println(nowDate.getDayOfWeek().getValue());

        // 月份
        System.out.println(nowDate.getMonth());
        System.out.println(nowDate.getMonth().getValue());

        System.out.println("------------------------");
        LocalDate bt = LocalDate.of(1991, 11, 11);
        System.out.println(bt); // 直接传入对应的年月日
        System.out.println(LocalDate.of(1991, Month.NOVEMBER, 11)); // 相对上面只是把月换成了枚举
    }
}
