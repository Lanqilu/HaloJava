package file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * @author Halo
 * @create 2021/10/30 下午 01:32
 * @description File 类测试
 */
public class FileTest {
    @Test
    public void t1() {
        // 1、创建 File 对象（指定了文件的路径）
        File f1 = new File("D:\\resources\\picture.png");
        File f2 = new File("D:/resources/picture.png");
        File f3 = new File("D:" + File.separator + "resources" + File.separator + "picture.png");
        long size = f1.length(); // 是文件的字节大小
        System.out.println(size);

        // 2、File 创建对象，支持绝对路径 支持相对路径（重点）
        // 绝对路径
        File f4 = new File("D:\\resources\\picture.png");
        System.out.println(f4.length());

        // 相对路径：一般定位模块中的文件的。 相对到工程下！！
        File f5 = new File("src\\main\\java\\file\\data.txt");
        System.out.println(f5.getAbsolutePath());
        System.out.println(f5.length());

        // 3、File创建对象 ，可以是文件也可以是文件夹
        File f6 = new File("D:\\resources");
        // 判断这个路径是否存在，这个文件夹存在否
        System.out.println(f6.exists());
    }


    @Test
    public void t2() {
        // 1.绝对路径创建一个文件对象
        File f1 = new File("D:/resources/picture.png");
        // a.获取它的绝对路径。
        System.out.println(f1.getAbsolutePath());
        // b.获取文件定义的时候使用的路径。
        System.out.println(f1.getPath());
        // c.获取文件的名称：带后缀。
        System.out.println(f1.getName());
        // d.获取文件的大小：字节个数。
        System.out.println(f1.length()); // 字节大小
        // e.获取文件的最后修改时间
        long time = f1.lastModified();
        System.out.println("最后修改时间：" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time));
        // f、判断文件是文件还是文件夹
        System.out.println(f1.isFile()); // true
        System.out.println(f1.isDirectory()); // false

        System.out.println("-------------------------");

        File f2 = new File("src\\main\\java\\file\\data.txt");
        // a.获取它的绝对路径。
        System.out.println(f2.getAbsolutePath());
        // b.获取文件定义的时候使用的路径。
        System.out.println(f2.getPath());
        // c.获取文件的名称：带后缀。
        System.out.println(f2.getName());
        // d.获取文件的大小：字节个数。
        System.out.println(f2.length()); // 字节大小
        // e.获取文件的最后修改时间
        long time1 = f2.lastModified();
        System.out.println("最后修改时间：" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(time1));

        // f、判断文件是文件还是文件夹
        System.out.println(f2.isFile()); // true
        System.out.println(f2.isDirectory()); // false
        System.out.println(f2.exists()); // true

        File file = new File("D:/");
        System.out.println(file.isFile()); // false
        System.out.println(file.isDirectory()); // true
        System.out.println(file.exists()); // true

        File file1 = new File("D:/aaa");
        System.out.println(file1.isFile()); // false
        System.out.println(file1.isDirectory()); // false
        System.out.println(file1.exists()); // false
    }

    @Test
    public void t3() throws IOException {
        File f = new File("src\\main\\java\\file\\data.txt");
        // a.创建新文件，创建成功返回true ,反之 ,不需要这个，以后文件写出去的时候都会自动创建
        System.out.println(f.createNewFile());
        File f1 = new File("src\\main\\java\\file\\data2.txt");
        System.out.println(f1.createNewFile()); // （几乎不用的，因为以后文件都是自动创建的！）

        // b.mkdir创建一级目录
        File f2 = new File("D:/resources/test");
        System.out.println(f2.mkdir());

        // c.mkdirs创建多级目录(重点)
        File f3 = new File("D:/resources/aaa/bbb/ccc/ddd");
        System.out.println(f3.mkdirs()); // 支持多级创建

        // d.删除文件或者空文件夹
        System.out.println(f1.delete());
        File f4 = new File("D:/resources/picture.png");
        System.out.println(f4.delete()); // 文件占用一样可以删除

        // 只能删除空文件夹,不能删除非空文件夹.
        File f5 = new File("D:/resources/test");
        System.out.println(f5.delete());
    }

    @Test
    public void t4() {
        // 1、定位一个目录
        File f1 = new File("D:/resources");
        String[] names = f1.list();
        for (String name : names) {
            System.out.println(name);
        }

        // 2.一级文件对象
        // 获取当前目录下所有的"一级文件对象"到一个文件对象数组中去返回（重点）
        File[] files = f1.listFiles();
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }

        // 注意事项
        File dir = new File("D:/resources/ddd");
        File[] files1 = dir.listFiles();
        System.out.println(Arrays.toString(files1));
    }

    /**
     * 1、搜索某个目录下的全部文件，找到我们想要的文件。
     *
     * @param dir      被搜索的源目录
     * @param fileName 被搜索的文件名称
     */
    public static void searchFile(File dir, String fileName) {
        // 3、判断dir是否是目录
        if (dir != null && dir.isDirectory()) {
            // 可以找了
            // 4、提取当前目录下的一级文件对象
            File[] files = dir.listFiles(); // null  []
            // 5、判断是否存在一级文件对象，存在才可以遍历
            if (files != null && files.length > 0) {
                for (File file : files) {
                    // 6、判断当前遍历的一级文件对象是文件 还是 目录
                    if (file.isFile()) {
                        // 7、是不是咱们要找的，是把其路径输出即可
                        if (file.getName().contains(fileName)) {
                            System.out.println("找到了：" + file.getAbsolutePath());
                            // 启动程序
                            try {
                                Runtime r = Runtime.getRuntime();
                                r.exec(file.getAbsolutePath());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    } else {
                        // 8、是文件夹，需要继续递归寻找
                        searchFile(file, fileName);
                    }
                }
            }
        } else {
            System.out.println("对不起，当前搜索的位置不是文件夹！");
        }
    }

    @Test
    public void t5() {
        // 2、传入目录 和 文件名称
        searchFile(new File("D:\\Application\\Application_Green"), "PotPlayerMini64.exe");
    }

    @Test
    public void t6()  {
        // 编码
        String s = "Hello World 你好 世界";
        byte[] b = s.getBytes();
        byte[] b2 = new byte[0];
        try {
            b2 = s.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(b.length);
        System.out.println(Arrays.toString(b));

        // 解码
        String rs = new String(b);
        String rs2 = null;
        try {
            rs2 = new String(b2,"GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(rs);
        System.out.println(rs2);
    }
}
