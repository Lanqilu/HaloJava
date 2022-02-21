package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Halo
 * @create 2021/10/29 下午 10:55
 * @description
 */
public class StreamTest {
    List<String> names = new ArrayList<>();

    @BeforeEach
    public void array() {
        Collections.addAll(names, "张三丰", "张无忌", "周芷若", "赵敏", "张强");
    }

    @Test
    public void old() {
        System.out.println(names);

        // 1、从集合中找出姓张的放到新集合
        List<String> zhangList = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("张")) {
                zhangList.add(name);
            }
        }
        System.out.println(zhangList);

        // 2、找名称长度是3的姓名
        List<String> zhangThreeList = new ArrayList<>();
        for (String name : zhangList) {
            if (name.length() == 3) {
                zhangThreeList.add(name);
            }
        }
        System.out.println(zhangThreeList);
    }

    @Test
    public void stream() {
        names.stream().filter(s -> s.startsWith("张")).filter(s -> s.length() == 3).forEach(System.out::println);
        long size = names.stream().filter(s -> s.length() == 3).count();
        System.out.println(size);

        names.stream().filter(s -> s.startsWith("张")).limit(2).forEach(System.out::println);

        names.stream().filter(s -> s.startsWith("张")).skip(2).forEach(System.out::println);

        // map 加工方法: 第一个参数原材料 -> 第二个参数是加工后的结果。
        // 给集合元素的前面都加上一个：Halo ：
        names.stream().map(s -> "Halo ：" + s).forEach(System.out::println);

        // 需求：把所有的名称 都加工成一个学生对象。
        // names.stream().map(Student::new).forEach(System.out::println); // 构造器引用  方法引用

        // 合并流。
        Stream<String> s1 = names.stream().filter(s -> s.startsWith("张"));
        Stream<String> s2 = Stream.of("Java1", "Java2");
        Stream<String> s3 = Stream.concat(s1, s2);
        s3.distinct().forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    class Employee {
        private String name;
        private char sex;
        private double salary;
        private double bonus;
        private String punish; // 处罚信息
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    class Topperformer {
        private String name;
        private double money; // 月薪
    }

    private static double allMoney;
    private static double allMoney2;


    @Test
    public void test() {
        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒", '男', 30000, 25000, null));
        one.add(new Employee("孙悟空", '男', 25000, 1000, "顶撞上司"));
        one.add(new Employee("沙僧", '男', 20000, 20000, null));
        one.add(new Employee("小白龙", '男', 20000, 25000, null));

        List<Employee> two = new ArrayList<>();
        two.add(new Employee("武松", '男', 15000, 9000, null));
        two.add(new Employee("李逵", '男', 20000, 10000, null));
        two.add(new Employee("西门庆", '男', 50000, 100000, "被打"));
        two.add(new Employee("潘金莲", '女', 3500, 1000, "被打"));
        two.add(new Employee("武大郎", '女', 20000, 0, "下毒"));

        // 获取工资最高的员工
        Employee employee = one.stream().max(Comparator.comparingDouble(e -> e.getSalary() + e.getBonus())).get();
        System.out.println(employee);

        // 获取工资最高的员工并封装成 Topperformer 对象
        Topperformer topperformer = one.stream().max(Comparator.comparingDouble(e -> e.getSalary() + e.getBonus()))
                .map(e -> new Topperformer(e.getName(), e.getSalary() + e.getBonus())).get();
        System.out.println(topperformer);


        // 统计 one 部门的平均月收入，去掉最高和最低
        one.stream().sorted(Comparator.comparingDouble(e -> e.getSalary() + e.getBonus())).skip(1).limit(one.size() - 2).forEach(e -> {
            allMoney += (e.getSalary() + e.getBonus());
        });
        System.out.println("one 部平均工资是" + allMoney / (one.size() - 2));

        // 统计两个部门整体的平均工资，去掉最高和最低
        Stream<Employee> s1 = one.stream();
        Stream<Employee> s2 = two.stream();
        Stream<Employee> s3 = Stream.concat(s1, s2);
        s3.sorted(Comparator.comparingDouble(e -> e.getSalary() + e.getBonus())).skip(1).limit(one.size() + two.size() - 2).forEach(e -> {
            allMoney2 += (e.getSalary() + e.getBonus());
        });
        BigDecimal a = BigDecimal.valueOf(allMoney2);
        BigDecimal b = BigDecimal.valueOf(one.size() + two.size() - 2);
        System.out.println("两个部门平均工资是" + a.divide(b, 2, RoundingMode.HALF_UP));
    }

    @Test
    public void t3() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");

        Stream<String> s1 = list.stream().filter(s -> s.startsWith("张"));
        List<String> zhangList = s1.collect(Collectors.toList()); // 可变集合
        zhangList.add("java1");
        System.out.println(zhangList);

        // JDK 16 得到不可变集合
        // List<String> list1 = s1.toList();
        // list1.add("java"); // 报错
        // System.out.println(list1);

        // 注意: “流只能使用一次”
        Stream<String> s2 = list.stream().filter(s -> s.startsWith("张"));
        Set<String> zhangSet = s2.collect(Collectors.toSet());
        System.out.println(zhangSet);

        Stream<String> s3 = list.stream().filter(s -> s.startsWith("张"));
        // Object[] arrs = s3.toArray();
        // 转成 String 数组
        String[] arrs = s3.toArray(String[]::new);
        System.out.println("Arrays数组内容：" + Arrays.toString(arrs));
    }


}
