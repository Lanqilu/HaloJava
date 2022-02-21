package thread;

import org.junit.jupiter.api.Test;

/**
 * @Date : 2020/2/13  21:09
 * @Author: Halo
 * @File : ThreadTest
 * @Version : v1.0
 * @Description: 多线程创建
 **/

/*  1. 创建一个继承与Thread类的子类
    2. 重写Thread类的run()方法
    3. 创建Thread类的子类的对象
    4. 通过此对象调用start()*/

public class CreateThread {

    public static void main(String[] args) {
        // 3.创建 Thread 类的子类的对象
        MyThread t1 = new MyThread();
        // 通过此对象调用start()
        t1.start(); // 线程开始执行或调用当前线程的run()方法
        //  t1.run(); // 直接调用 run() 方法是单线程

        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());

        // 再创建线程
        // t1.start(); // 报错: IllegalThreadStateException

        // 重新创建一个线程对象
        MyThread t2 = new MyThread();
        t2.start();
    }


    @Test
    public void t(){
        Thread t1 = new MyTestThread("1号");
        // t1.setName("1号");
        t1.start();
        System.out.println(t1.getName());

        Thread t2 = new MyTestThread("2号");
        // t2.setName("2号");
        t2.start();
        System.out.println(t2.getName());

        // 哪个线程执行它，它就得到哪个线程对象（当前线程对象）
        // 主线程的名称就叫main
        Thread m = Thread.currentThread();
        System.out.println(m.getName());
        m.setName("最牛的线程");

        for (int i = 0; i < 5; i++) {
            System.out.println( m.getName() + "输出：" + i);
        }
    }
}

class MyTestThread extends Thread{
    public MyTestThread() {
    }

    public MyTestThread(String name) {
        // 为当前线程对象设置名称，送给父类的有参数构造器初始化名称
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println( Thread.currentThread().getName() + "输出：" + i);
        }
    }
}



// 1.创建一个继承与 Thread 类的子类
class MyThread extends Thread {
    // 2.重写 Thread 类的 run() 方法, 将此线程的操作声明在 run() 中
    @Override
    public void run() {
        // 获取当前线程的名字
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        for (int i = 0; i < 50; i++) {
            if (i % 10 == 0) {
                System.out.println(Thread.currentThread().getName() + " i = " + i);
            }
        }
    }
}
