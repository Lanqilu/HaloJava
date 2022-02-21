package properties;

import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author Halo
 * @create 2021/10/30 下午 11:36
 * @description
 */
public class PropertiesTest {
    @Test
    public void t1() throws Exception {
        // 需求：使用 Properties 把键值对信息存入到属性文件中去。
        Properties properties = new Properties();
        properties.setProperty("admin", "123456");
        properties.setProperty("halo", "003197");
        properties.setProperty("test", "test");
        System.out.println(properties);

        /**
         参数一：保存管道 字符输出流管道
         参数二：保存心得
         */
        properties.store(new FileWriter("src/main/java/properties/users.properties"),
                "comments");
    }

    @Test
    public void t2() throws Exception{
        // 需求：Properties 读取属性文件中的键值对信息。（读取）
        Properties properties = new Properties();
        System.out.println(properties);

        // 加载属性文件中的键值对数据到属性对象properties中去
        properties.load(new FileReader("src/main/java/properties/users.properties"));

        System.out.println(properties);

        String rs = properties.getProperty("halo");
        System.out.println(rs);

        String rs1 = properties.getProperty("admin");
        System.out.println(rs1);
    }
}
