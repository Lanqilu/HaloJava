package thread.timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
    目标：Timer定时器的使用和了解。
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        // 1、创建 Timer 定时器
        Timer timer = new Timer();  // 定时器本身就是一个单线程。
        // 2、调用方法，处理定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 执行 AAA ~~~ " + new Date());
            }
        }, 0, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 执行 BBB ~~~ "+ new Date());
                System.out.println(10/0);
            }
        }, 0, 2000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "执行 CCC ~~~ "+ new Date());
            }
        }, 0, 3000);
    }
}
