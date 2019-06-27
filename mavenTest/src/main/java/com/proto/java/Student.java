package com.proto.java;

import java.io.Serializable;

/**
 * 玩家对象
 *
 * @author -琴兽-
 */
public class Student implements Serializable {


    private float grade;

    private int age;

    private String name;

    public Student(float grade, int age, String name) {
        this.grade = grade;
        this.age = age;
        this.name = name;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
