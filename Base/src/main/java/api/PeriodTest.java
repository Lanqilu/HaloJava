package api;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author Halo
 * @create 2021/10/29 下午 07:31
 * @description
 */
public class PeriodTest {
    public static void main(String[] args) {
        // 当前本地 年月日
        LocalDate today = LocalDate.now();
        System.out.println(today);//

        // 生日的 年月日
        LocalDate birthDate = LocalDate.of(1988, 1, 7);
        System.out.println(birthDate);

        Period period = Period.between(birthDate, today); // 第二个参数减第一个参数

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }
}
