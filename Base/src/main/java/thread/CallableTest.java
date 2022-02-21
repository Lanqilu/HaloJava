package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author Halo
 * @create 2021/10/31 下午 01:55
 * @description
 */
public class CallableTest {
    public static void main(String[] args) {
        // 3、创建 Callable 任务对象
        Callable<String> call = new MyCallable(10000);

        // 4、把 Callable 任务对象 交给 FutureTask 对象
        //  FutureTask 对象的作用 1： 是 Runnable 的对象（实现了 Runnable 接口），可以交给 Thread 了
        //  FutureTask 对象的作用 2： 可以在线程执行完毕之后通过调用其 get 方法得到线程执行完成的结果
        FutureTask<String> f1 = new FutureTask<>(call);

        // 5、交给线程处理
        Thread t1 = new Thread(f1);

        // 6、启动线程
        t1.start();

        // 启动另一个线程
        Callable<String> call2 = new MyCallable(20000);
        FutureTask<String> f2 = new FutureTask<>(call2);
        Thread t2 = new Thread(f2);
        t2.start();

        try {
            // 如果s f1 任务没有执行完毕，这里的代码会等待，直到线程 1 跑完才提取结果。
            String rs1 = f1.get();
            System.out.println("第一个结果：" + rs1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 如果 f2 任务没有执行完毕，这里的代码会等待，直到线程 2 跑完才提取结果。
            String rs2 = f2.get();
            System.out.println("第二个结果：" + rs2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


/**
 * 1、定义一个任务类 实现Callable接口
 * 应该申明线程任务执行完毕后的结果的数据类型
 */
class MyCallable implements Callable<String> {
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    /**
     * 2、重写call方法（任务方法）
     */
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "执行的结果是：" + sum + "\t" + Thread.currentThread().getName();
    }
}
