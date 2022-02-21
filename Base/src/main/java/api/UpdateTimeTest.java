package api;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * @author Halo
 * @create 2021/10/29 下午 07:19
 * @description
 */
public class UpdateTimeTest {
    public static void main(String[] args) {
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime); // 当前时间
        System.out.println(nowTime.minusHours(1)); // 一小时前
        System.out.println(nowTime.minusMinutes(1)); // 一分钟前
        System.out.println(nowTime.minusSeconds(1)); // 一秒前
        System.out.println(nowTime.minusNanos(1)); // 一纳秒前

        System.out.println("----------------");

        System.out.println(nowTime.plusHours(1)); // 一小时后
        System.out.println(nowTime.plusMinutes(1)); // 一分钟后
        System.out.println(nowTime.plusSeconds(1)); // 一秒后
        System.out.println(nowTime.plusNanos(1)); // 一纳秒后

        System.out.println("------------------");

        // 不可变对象，每次修改产生新对象！
        System.out.println(nowTime);

        System.out.println("---------------");
        LocalDate myDate = LocalDate.of(2018, 9, 5);
        LocalDate nowDate = LocalDate.now();

        System.out.println("今天是 2018-09-06 吗？ " + nowDate.equals(myDate)); // 今天是 2018-09-06 吗？ false
        System.out.println(myDate + "是否在" + nowDate + "之前？ " + myDate.isBefore(nowDate));// 2018-09-05 是否在 2018-09-06 之前？ true
        System.out.println(myDate + "是否在" + nowDate + "之后？ " + myDate.isAfter(nowDate));//2018-09-05 是否在 2018-09-06 之后？ false

        System.out.println("---------------------------");

        // 判断今天是否是你的生日
        LocalDate birDate = LocalDate.of(1996, 8, 5);
        LocalDate nowDate1 = LocalDate.now();

        MonthDay birMd = MonthDay.of(birDate.getMonthValue(), birDate.getDayOfMonth());
        MonthDay nowMd = MonthDay.from(nowDate1);

        System.out.println("今天是你的生日吗？ " + birMd.equals(nowMd)); // 今天是你的生日吗？ false
    }
}
