package api;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Halo
 * @create 2021/10/29 下午 05:29
 * @description
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        // 浮点型运算的时候直接+  * / 可能会出现数据失真（精度问题）。
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        System.out.println("-------------------------");
        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);
        System.out.println("--------------------------");
        // 包装浮点型数据成为大数据对象 BigDeciaml
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        BigDecimal c1 = a1.add(b1);
        // BigDecimal c1 = a1.subtract(b1);
        // BigDecimal c1 = a1.multiply(b1);
        // BigDecimal c1 = a1.divide(b1);
        System.out.println(c1);

        // 目的：double
        double rs = c1.doubleValue();
        System.out.println(rs);

        // 注意事项：BigDecimal是一定要精度运算的
        BigDecimal a11 = BigDecimal.valueOf(10.0);
        BigDecimal b11 = BigDecimal.valueOf(3.0);

        /**
         参数一：除数 参数二：保留小数位数  参数三：舍入模式
         */
        BigDecimal c11 = a11.divide(b11, 2, RoundingMode.HALF_UP); // 3.3333333333
        System.out.println(c11);


        System.out.println("-------------------");
    }
}

