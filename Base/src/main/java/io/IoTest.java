package io;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Halo
 * @create 2021/10/30 下午 04:07
 * @description
 */
public class IoTest {
    @Test
    public void t1() throws IOException {
        // 1、创建一个文件字节输入流管道与源文件接通。
        InputStream is = new FileInputStream(new File("src\\main\\java\\io\\data.txt"));

        // 2、读取一个字节返回 （每次读取一滴水）
        int b1 = is.read();
        System.out.println((char) b1);

        int b2 = is.read();
        System.out.println((char) b2);

        int b3 = is.read();
        System.out.println((char) b3);

        int b4 = is.read(); // 读取完毕返回 -1
        System.out.println(b4);
    }

    @Test
    public void t2() throws IOException {
        // 简化写法
        InputStream is = new FileInputStream("src\\main\\java\\io\\data.txt");

        // 使用循环改进, 定义一个变量记录每次读取的字节
        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }
    }

    @Test
    public void t3() throws Exception {
        // 1、创建一个文件字节输入流管道与源文件接通
        InputStream is = new FileInputStream("src\\main\\java\\io\\data.txt");

        // 2、定义一个字节数组，用于读取字节数组
        byte[] buffer = new byte[3]; // 3B
        int len = is.read(buffer);
        System.out.println("读取了几个字节：" + len);
        String rs = new String(buffer);
        System.out.println(rs);

        int len1 = is.read(buffer);
        System.out.println("读取了几个字节：" + len1);
        String rs1 = new String(buffer);
        System.out.println(rs1);
        // buffer = [a b c]

        // 桶内还存在没覆盖的 c
        // buffer = [a b c]  ==>  [c d c]
        int len2 = is.read(buffer);
        System.out.println("读取了几个字节：" + len2);
        // 读取多少倒出多少
        String rs2 = new String(buffer, 0, len2);
        System.out.println(rs2);

        int len3 = is.read(buffer);
        System.out.println(len3); // 读取完毕返回 -1
    }

    @Test
    public void t4() throws Exception {
        InputStream is = new FileInputStream("src\\main\\java\\io\\data.txt");

        // 改进使用循环，每次读取一个字节数组
        byte[] buffer = new byte[3];
        int len; // 记录每次读取的字节数。
        while ((len = is.read(buffer)) != -1) {
            // 读取多少倒出多少
            System.out.print(new String(buffer, 0, len));
        }
    }

    @Test
    public void t5() throws Exception {
        // 1、创建一个文件字节输入流管道与源文件接通
        File f = new File("src\\main\\java\\io\\data.txt");
        InputStream is = new FileInputStream(f);

        // 2、定义一个字节数组与文件的大小刚刚一样大。
        byte[] buffer = new byte[(int) f.length()];
        int len = is.read(buffer);
        System.out.println("读取了多少个字节：" + len);
        System.out.println("文件大小：" + f.length());
        System.out.println(new String(buffer));
    }


    @Test
    public void t6() throws Exception {
        InputStream is = new FileInputStream("src\\main\\java\\io\\data.txt");
        byte[] buffer = is.readAllBytes();
        System.out.println(new String(buffer));
    }


    @Test
    public void t7() throws Exception {
        // 1、创建一个文件字节输出流管道与目标文件接通
        OutputStream os = new FileOutputStream("src\\main\\java\\io\\out.txt", true); // 追加数据管道
        // OutputStream os = new FileOutputStream("src\main\java\io\out04.txt"); // 先清空之前的数据，写新数据进入

        // 2、写数据出去
        os.write('a');
        os.write(98);
        os.write("\r\n".getBytes()); // 换行
        // os.write('徐'); // [ooo]

        // b.public void write(byte[] buffer):写一个字节数组出去。
        byte[] buffer = {'a', 97, 98, 99};
        os.write(buffer);
        os.write("\r\n".getBytes()); // 换行

        byte[] buffer2 = "我是中国人".getBytes();
        // byte[] buffer2 = "我是中国人".getBytes("GBK");
        os.write(buffer2);
        os.write("\r\n".getBytes()); // 换行


        // c. public void write(byte[] buffer , int pos , int len):写一个字节数组的一部分出去。
        byte[] buffer3 = {'a', 97, 98, 99};
        os.write(buffer3, 0, 3);
        os.write("\r\n".getBytes()); // 换行

        // os.flush(); // 写数据必须，刷新数据 可以继续使用流
        os.close(); // 释放资源，包含了刷新的！关闭后流不可以使用了
    }


    @Test
    public void t8() throws Exception {
        // 1、创建一个文件字节输出流管道与目标文件接通
        OutputStream os = new FileOutputStream("src\\main\\java\\io\\out.txt", true); // 追加数据管道
        // OutputStream os = new FileOutputStream("src\\main\\java\\io\\out.txt"); // 先清空之前的数据，写新数据进入
        // 2、写数据出去
        os.write('a');
        os.write(98);
        os.write("\r\n".getBytes()); // 换行
        // 释放资源，包含了刷新的！关闭后流不可以使用了
        os.close();
    }

    @Test
    public void t9() throws Exception {
        // 1、创建一个文件字节输出流管道与目标文件接通
        OutputStream os = new FileOutputStream("src\\main\\java\\io\\out2.txt", true); // 追加数据管道

        // public void write(byte[] buffer):写一个字节数组出去。
        byte[] buffer = {'a', 97, 98, 99};
        os.write(buffer);
        os.write("\r\n".getBytes()); // 换行

        byte[] buffer2 = "你好世界".getBytes();
        os.write(buffer2);
        os.write("\r\n".getBytes()); // 换行

        // public void write(byte[] buffer , int pos , int len):写一个字节数组的一部分出去。
        byte[] buffer3 = {'a', 97, 98, 99};
        os.write(buffer3, 0, 3);
        os.write("\r\n".getBytes()); // 换行

        os.close();
    }

    @Test
    public void t10() {
        try {
            // 1、创建一个字节输入流管道与原视频接通
            InputStream is = new FileInputStream("src\\main\\java\\io\\out.txt");

            // 2、创建一个字节输出流管道与目标文件接通
            OutputStream os = new FileOutputStream("src\\main\\java\\io\\copy_out.txt");

            // 3、定义一个字节数组转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成了！");

            // 4、关闭流。
            os.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void t11() {
        InputStream is = null;
        OutputStream os = null;
        try {
            // System.out.println(10 / 0);

            // 1、创建一个字节输入流管道与原视频接通
            is = new FileInputStream("src\\main\\java\\io\\out.txt");

            // 2、创建一个字节输出流管道与目标文件接通
            os = new FileOutputStream("src\\main\\java\\io\\copy_out.txt");


            // 3、定义一个字节数组转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数。
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成了！");

            // System.out.println(10 / 0);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 无论代码是正常结束，还是出现异常都要最后执行这里
            System.out.println("======== finally =========");
            try {
                // 4、关闭流。
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void t12() {
        try (
                // 这里面只能放置资源对象，用完会自动关闭：自动调用资源对象的close方法关闭资源（即使出现异常也会做关闭操作）

                InputStream is = new FileInputStream("src\\main\\java\\io\\out.txt");
                OutputStream os = new FileOutputStream("src\\main\\java\\io\\copy_out.txt");

                // int age = 23; // 这里只能放资源
                MyConnection connection = new MyConnection(); // 最终会自动调用资源的close方法
        ) {
            // 3、定义一个字节数组转移数据
            byte[] buffer = new byte[1024];
            int len; // 记录每次读取的字节数。
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
            System.out.println("复制完成了！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class MyConnection implements AutoCloseable{
        @Override
        public void close() throws IOException {
            System.out.println("连接资源被成功释放了！");
        }
    }
}
