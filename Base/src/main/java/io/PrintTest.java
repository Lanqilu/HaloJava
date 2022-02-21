package io;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author Halo
 * @create 2021/10/30 下午 11:08
 * @description
 */
public class PrintTest {

    @Test
    public void t1() throws FileNotFoundException {
        // 1、创建一个打印流对象
        PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/io/data.txt"));
//        PrintStream ps = new PrintStream(new FileOutputStream("src/main/java/io/data.txt" , true)); // 追加数据，在低级管道后面加True
//        PrintStream ps = new PrintStream("src/main/java/io/data.txt" );
//        PrintWriter ps = new PrintWriter("src/main/java/io/data.txt"); // 打印功能上与 PrintStream 的使用没有区别

        ps.println(97);
        ps.println('a');
        ps.println(23.3);
        ps.println(true);
        ps.println("我是打印流输出的，我是啥就打印啥");

        ps.close();
    }

    @Test
    public void t2() throws Exception{
        System.out.println("Halo");
        System.out.println("Halo");
        System.out.println("Halo");

        PrintStream printStream = new PrintStream("src/main/java/io/log.txt");
        System.setOut(printStream);

        System.out.println("Test");
        System.out.println("Test");
        System.out.println("Test");
    }
}
