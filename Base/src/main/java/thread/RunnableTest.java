package thread;

import org.junit.jupiter.api.Test;

/**
 * @author Halo
 * @create 2021/10/31 下午 01:39
 * @description
 */
public class RunnableTest {
    @Test
    public void t() {
        // 3、创建一个任务对象
        Runnable target = new MyRunnable();
        // 4、把任务对象交给 Thread 处理
        Thread t = new Thread(target);
        // Thread t = new Thread(target, "1号");
        // 5、启动线程
        t.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ---- " + Thread.currentThread().getName());
        }
    }

    @Test
    public void t1() {
        Runnable target = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " ---- " + Thread.currentThread().getName());
            }
        };
        Thread t = new Thread(target);
        t.start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " ---- " + Thread.currentThread().getName());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " ---- " + Thread.currentThread().getName());
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ---- " + Thread.currentThread().getName());
        }
    }
}

/**
 * 1、定义一个线程任务类 实现 Runnable 接口
 */
class MyRunnable implements Runnable {
    /**
     * 2、重写 run 方法，定义线程的执行任务的
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " ---- " + Thread.currentThread().getName());
        }
    }
}
