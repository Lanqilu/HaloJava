package entity;

import java.util.Objects;

/**
 * @author Halo
 * @create 2021/10/29 下午 03:08
 * @description
 */
public class Student extends Human {
    private int grade;
    private int id;


    @Override
    public int hashCode() {
        return Objects.hash(grade, id);
    }

    public Student(String name, char sex, int age) {
        super(name, sex, age);
    }

    public Student(String name, char sex, int age, int grade, int id) {
        super(name, sex, age);
        this.grade = grade;
        this.id = id;
    }

    public Student() {
    }

    public Student(int grade, int id) {
        this.grade = grade;
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
