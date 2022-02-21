package api;

import entity.Human;
import entity.Student;

/**
 * @author Halo
 * @create 2021/10/29 下午 03:10
 * @description
 */
public class ObjectTest {
    public static void main(String[] args) {
        Student student = new Student("Halo", '男', 18);
        Human human = new Human("Halo", '男', 18);
        System.out.println(human.equals(student));
    }
}
