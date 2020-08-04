package com.qfedu.entity;

/**
 * @Auther: Lcs
 * @Date: 2020/7/4 17:46
 * @Description:
 */
public class Student {
    private int ID;
    private String name;
    private String grade;
    private int age;
    private int teacher_ID;

    public Student() {
    }

    public Student(int ID, String name, String grade, int age, int teacher_ID) {
        this.ID = ID;
        this.name = name;
        this.grade = grade;
        this.age = age;
        this.teacher_ID = teacher_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTeacher_ID() {
        return teacher_ID;
    }

    public void setTeacher_ID(int teacher_ID) {
        this.teacher_ID = teacher_ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", age=" + age +
                ", teacher_ID=" + teacher_ID +
                '}';
    }
}
