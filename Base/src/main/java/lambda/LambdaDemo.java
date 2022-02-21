package lambda;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Halo
 * @create 2021/10/29 下午 10:33
 * @description
 */
public class LambdaDemo {

    public static void goSwimming(Swimming swimming) {
        swimming.swim();
    }

    @FunctionalInterface
    interface Swimming {
        void swim();
    }

    @Test
    public void t1() {
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("铁汁, 我们去游泳吧~");
            }
        });
    }

    @Test
    public void t2() {
        goSwimming(() -> System.out.println("铁汁, 我们去游泳吧~"));
    }

    @Test
    public void t3(){
        Integer[] ages = {66, 33, 22, 55, 88};

        Arrays.sort(ages, (o1, o2) -> o2 - o1);

        System.out.println("内容:" + Arrays.toString(ages));
    }
}
