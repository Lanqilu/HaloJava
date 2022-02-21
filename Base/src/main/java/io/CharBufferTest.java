package io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Halo
 * @create 2021/10/30 下午 10:00
 * @description
 */
public class CharBufferTest {
    @Test
    public void t1() {
        try (
                // 1、创建一个文件字符输入流与源文件接通。
                Reader fr = new FileReader("src/main/java/io/data.txt");
                // a、把低级的字符输入流包装成高级的缓冲字符输入流。
                BufferedReader br = new BufferedReader(fr);
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t2() throws IOException {
        // 1、创建一个字符输出流管道与目标文件接通
        Writer fw = new FileWriter("src/main/java/io/out.txt"); // 覆盖管道，每次启动都会清空文件之前的数据
        //Writer fw = new FileWriter("io-app2/src/out02.txt", true); // 追加数据
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Hello World");
        bw.newLine(); // bw.write("\r\n"); // 换行

        // fw.flush();// 刷新后流可以继续使用
        bw.close(); // 关闭包含刷线，关闭后流不能使用
    }

    @Test
    public void t3() {
        try (
                // 1、创建缓冲字符输入流管道与源文件接通
                BufferedReader br = new BufferedReader(new FileReader("src/main/java/io/csb.txt"));

                // 5、定义缓冲字符输出管道与目标文件接通
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/io/csb_new.txt"));
        ) {

            // 2、定义一个List集合存储每行内容
            List<String> data = new ArrayList<>();
            // 3、定义循环，按照行读取文章
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
            System.out.println(data);

            // 4、排序
            // 自定义排序规则
            List<String> sizes = new ArrayList<>();
            Collections.addAll(sizes, "一", "二", "三", "四", "五", "陆", "柒", "八", "九", "十", "十一");

            Collections.sort(data, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return sizes.indexOf(o1.substring(0, o1.indexOf(".")))
                            - sizes.indexOf(o2.substring(0, o2.indexOf(".")));
                }
            });

            // 简化
            // data.sort(Comparator.comparingInt(o -> sizes.indexOf(o.substring(0, o.indexOf(".")))));

            System.out.println(data);

            // 6、遍历集合中的每行文章写出去，且要换行
            for (String datum : data) {
                bw.write(datum);
                bw.newLine(); // 换行
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void t4() throws Exception {
        // 1、定义一个字节输出流
        OutputStream os = new FileOutputStream("src/main/java/io/out.txt");

        // 2、把原始的字节输出流转换成字符输出流
        // 以默认的 UTF-8 写字符出去 跟直接写 FileWriter 一样
        // Writer osw = new OutputStreamWriter(os);
        // 指定 GBK 的方式写字符出去
        Writer osw = new OutputStreamWriter(os, "GBK");

        // 3、把低级的字符输出流包装成高级的缓冲字符输出流。
        BufferedWriter bw = new BufferedWriter(osw);

        bw.write("Hello World");
        bw.write("你好 世界");
        bw.write("你好 世界 Hello World");

        bw.close();
    }
}
