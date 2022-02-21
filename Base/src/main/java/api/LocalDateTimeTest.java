package api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author Halo
 * @create 2021/10/29 下午 07:13
 * @description
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        // 日期 时间
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("今天是：" + nowDateTime); // 今天是：
        System.out.println(nowDateTime.getYear()); // 年
        System.out.println(nowDateTime.getMonthValue()); // 月
        System.out.println(nowDateTime.getDayOfMonth()); // 日
        System.out.println(nowDateTime.getHour()); // 时
        System.out.println(nowDateTime.getMinute()); // 分
        System.out.println(nowDateTime.getSecond()); // 秒
        System.out.println(nowDateTime.getNano()); // 纳秒
        // 日：当年的第几天
        System.out.println("dayOfYear：" + nowDateTime.getDayOfYear()); // dayOfYear：249
        // 星期
        System.out.println(nowDateTime.getDayOfWeek());
        System.out.println(nowDateTime.getDayOfWeek().getValue());
        // 月份
        System.out.println(nowDateTime.getMonth());
        System.out.println(nowDateTime.getMonth().getValue());

        // 转成 LocalDate 对象
        LocalDate ld = nowDateTime.toLocalDate();
        System.out.println(ld);
        // 转成 LocalTime 对象
        LocalTime lt = nowDateTime.toLocalTime();
        System.out.println(lt.getHour());
        System.out.println(lt.getMinute());
        System.out.println(lt.getSecond());
    }
}
