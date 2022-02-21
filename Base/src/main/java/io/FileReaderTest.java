package io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Halo
 * @create 2021/10/30 下午 08:42
 * @description
 */
public class FileReaderTest {
    @Test
    public void t1() throws IOException {
        // 目标：每次读取一个字符。
        // 1、创建一个字符输入流管道与源文件接通
        Reader fr = new FileReader("src\\main\\java\\io\\data.txt");

        // 2、读取一个字符返回，没有可读的字符了返回-1
        int code = fr.read();
        System.out.print((char) code);

        int code1 = fr.read();
        System.out.print((char) code1);
    }

    @Test
    public void t2() throws IOException {
        Reader fr = new FileReader("src\\main\\java\\io\\data.txt");
        int code;
        while ((code = fr.read()) != -1) {
            System.out.print((char) code);
        }
    }

    @Test
    public void t3() throws IOException {
        // 1、创建一个文件字符输入流与源文件接通
        Reader fr = new FileReader("src\\main\\java\\io\\data.txt");

        // 2、用循环，每次读取一个字符数组的数据。  1024 + 1024 + 8
        char[] buffer = new char[1024]; // 1K字符
        int len;
        while ((len = fr.read(buffer)) != -1) {
            String rs = new String(buffer, 0, len);
            System.out.print(rs);
        }
    }

    @Test
    public void t4() throws IOException {
        // 1、创建一个字符输出流管道与目标文件接通
        // Writer fw = new FileWriter("src\\\\main\\\\java\\\\io\\\\data.txt"); // 覆盖管道，每次启动都会清空文件之前的数据
        Writer fw = new FileWriter("src\\main\\java\\io\\data.txt", true); // 覆盖管道，每次启动都会清空文件之前的数据

        // a. public void write(int c): 写一个字符出去
        fw.write(98);
        fw.write('a');
        fw.write('徐'); // 不会出问题了
        fw.write("\r\n"); // 换行

        // b. public void write(String c): 写一个字符串出去
        fw.write("你好世界 Hello World");
        fw.write("\r\n"); // 换行


        // c. public void write(char[] buffer): 写一个字符数组出去
        char[] chars = "123 你好世界 Hello World".toCharArray();
        fw.write(chars);
        fw.write("\r\n"); // 换行

        // d. public void write(String c ,int pos ,int len): 写字符串的一部分出去
        fw.write("你好世界 Hello World", 0, 2);
        fw.write("\r\n"); // 换行


        // e. public void write(char[] buffer ,int pos ,int len): 写字符数组的一部分出去
        fw.write(chars, 4, 4);


        // fw.flush(); // 刷新后流可以继续使用
        fw.close();    // 关闭包含刷线，关闭后流不能使用
    }
}
