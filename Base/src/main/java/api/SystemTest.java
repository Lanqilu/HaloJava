package api;

import java.util.Arrays;

/**
 * @author Halo
 * @create 2021/10/29 下午 05:12
 * @description
 */
public class SystemTest {
    public static void main(String[] args) {
        System.out.println("程序开始。。。");

        // System.exit(0); // JVM终止！

        // 2、计算机认为时间有起源：返回1970-1-1 00：00：00 走到此刻的总的毫秒值：时间毫秒值。
        long time = System.currentTimeMillis();
        System.out.println(time);

        long startTime = System.currentTimeMillis();
        long sum = 1;
        // 进行时间的计算：性能分析
        for (int i = 0; i < 1000000; i++) {
            sum *= i;
        }
        System.out.println(sum);
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime) / 1000.0 + "s");


        // 3、做数组拷贝（了解）
        /**
         arraycopy(Object src,  int  srcPos,
         Object dest, int destPos,
         int length)
         参数一：被拷贝的数组
         参数二：从哪个索引位置开始拷贝
         参数三：复制的目标数组
         参数四：粘贴位置
         参数五：拷贝元素的个数
         */
        int[] arr1 = {10, 20, 30, 40, 50, 60, 70};
        int[] arr2 = new int[6]; // [0, 0, 0, 0, 0, 0] ==>  [0, 0, 40, 50, 60, 0]
        System.arraycopy(arr1, 3, arr2, 2, 3);
        System.out.println(Arrays.toString(arr2));

        System.out.println("-------------------");
        double i = 10.0;
        double j = 3.0;

//
//        System.out.println(k1);

        System.out.println("程序结束。。。。");
    }
}
