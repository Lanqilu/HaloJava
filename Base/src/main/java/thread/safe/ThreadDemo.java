package thread.safe;

/**
    需求：模拟取钱案例。
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 1、定义线程类，创建一个共享的账户对象
        Account acc = new Account("ICBC-111", 100000);

        // 2、创建 2 个线程对象，代表小明和小红同时进来了。
        new DrawThread(acc, "小明").start();
        new DrawThread(acc, "小红").start();

        // 1、定义线程类，创建一个共享的账户对象
        Account acc2 = new Account("ICBC-112", 100000);

        // 2、创建 2 个线程对象，代表小明和小红同时进来了。
        new DrawThread(acc2, "小明2").start();
        new DrawThread(acc2, "小红2").start();
    }
}
