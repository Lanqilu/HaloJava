package api;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Halo
 * @create 2021/10/29 下午 07:25
 * @description
 */
public class InstantTest {
    public static void main(String[] args) {
        // 1、得到一个 Instant 时间戳对象
        Instant instant = Instant.now();
        System.out.println(instant);

        // 2、系统此刻的时间戳怎么办?
        Instant instant1 = Instant.now();
        System.out.println(instant1.atZone(ZoneId.systemDefault()));

        // 3、如何去返回 Date 对象
        Date date = Date.from(instant);
        System.out.println(date);

        Instant i2 = date.toInstant();
        System.out.println(i2);
    }
}
