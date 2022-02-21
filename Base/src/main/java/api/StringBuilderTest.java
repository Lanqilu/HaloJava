package api;

import org.junit.jupiter.api.Test;

/**
 * @author Halo
 * @create 2021/10/29 下午 04:31
 * @description
 */
public class StringBuilderTest {
    @Test
    public void t1() {
        StringBuilder sb = new StringBuilder(1024);
        for (int i = 0; i < 1000; i++) {
            sb.append(',');
            sb.append(i);
        }

        System.out.println(sb);
    }

    @Test
    public void t2() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(toString(arr));
    }

    public static String toString(int[] arr) {
        if (arr != null) {
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i == arr.length - 1 ? "" : ",");
            }
            sb.append("]");
            return sb.toString();
        } else {
            return null;
        }
    }
}
