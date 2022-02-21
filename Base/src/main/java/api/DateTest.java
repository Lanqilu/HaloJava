package api;

import java.util.Date;

/**
 * @author Halo
 * @create 2021/10/29 下午 05:43
 * @description
 */
public class DateTest {
    public static void main(String[] args) {
        // 1、创建一个 Date 类的对象：代表系统此刻日期时间对象
        Date d = new Date();
        System.out.println(d);

        // 2、获取时间毫秒值
        long time = d.getTime();
        System.out.println(time);

        long time1 = System.currentTimeMillis();
        System.out.println(time1);

        System.out.println("----------------------------");
        
        // 1、得到当前时间
        Date d1 = new Date();
        System.out.println(d1);

        // 2、当前时间往后走 1小时
        long time2 = System.currentTimeMillis();
        time2 += (60 * 60) * 1000;

        // 3、把时间毫秒值转换成对应的日期对象。
        Date d2 = new Date(time2);
        System.out.println(d2);
    }
}
