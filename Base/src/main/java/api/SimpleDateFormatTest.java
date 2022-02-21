package api;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Halo
 * @create 2021/10/29 下午 06:42
 * @description
 */
public class SimpleDateFormatTest {
    @Test
    public void t1() {
        // 1、日期对象
        Date d = new Date();
        System.out.println(d);

        // 2、格式化这个日期对象 (指定最终格式化的形式)
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        // 3、开始格式化日期对象成为喜欢的字符串形式
        String rs = sdf.format(d);
        System.out.println(rs);

        System.out.println("----------------------------");

        // 4、格式化时间毫秒值
        // 需求：请问121秒后的时间是多少
        long time1 = System.currentTimeMillis() + 121 * 1000;
        String rs2 = sdf.format(time1);
        System.out.println(rs2);
    }

    @Test
    public void t2() throws ParseException {
        // 目标: 学会使用 SimpleDateFormat 解析字符串时间成为日期对象。
        // 有一个时间 2021年08月06日 11:11:11 往后 2 天 14 小时 49 分 06 秒后的时间是多少。
        // 1、把字符串时间拿到程序中来
        String dateStr = "2021年08月06日 11:11:11";

        // 2、把字符串时间解析成日期对象: 形式必须与被解析时间的形式完全一样，否则运行时解析报错！
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d = sdf.parse(dateStr);

        // 3、往后走 2 天 14 小时 49 分 06 秒
        long time = d.getTime() + (2L * 24 * 60 * 60 + 14 * 60 * 60 + 49 * 60 + 6) * 1000;

        // 4、格式化这个时间毫秒值就是结果
        System.out.println(sdf.format(time));
    }
}
