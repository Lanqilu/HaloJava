package io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Halo
 * @create 2021/10/30 下午 11:45
 * @description
 */
public class CommonsIoTest {

    @Test
    public void t1() throws Exception {
        // 1.完成文件复制！
        IOUtils.copy(new FileInputStream("src/main/java/io/data.txt"),
                new FileOutputStream("src/main/java/io/data_copy.txt"));

        // 2.完成文件复制到某个文件夹下
        FileUtils.copyFileToDirectory(new File("src/main/java/io/data.txt"), new File("D:/resources"));


        // 3.完成文件夹复制到某个文件夹下
        FileUtils.copyDirectoryToDirectory(new File("D:/resources"), new File("D:/resources_copy"));


        // 删除文件夹
        FileUtils.deleteDirectory(new File("D:/resources"));


        // JDK 1.7 自己也做了一些一行代码完成复制的操作: New IO 的技术
        Files.copy(Path.of("src/main/java/io/data.txt"), Path.of("src/main/java/io/data_new.txt"));

        FileUtils.deleteDirectory(new File("D:/resources_copy"));
    }
}
