package serializable;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author Halo
 * @create 2021/10/30 下午 10:52
 * @description
 */
public class ObjectOutputStreamTest {
    @Test
    public void t1() throws Exception {
        // 1、创建学生对象
        Student s = new Student("张三", "zhangsan", "zhangsan", 21);

        // 2、对象序列化：使用对象字节输出流包装字节输出流管道
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/main/java/serializable/obj.txt"));

        // 3、直接调用序列化方法
        oos.writeObject(s);

        // 4、释放资源
        oos.close();
        System.out.println("序列化完成了~~");
    }

    @Test
    public void t2() throws Exception {
        // 1、创建对象字节输入流管道包装低级的字节输入流管道
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("src/main/java/serializable/obj.txt"));

        // 2、调用对象字节输入流的反序列化方法
        Student s = (Student) is.readObject();

        System.out.println(s);
    }
}
