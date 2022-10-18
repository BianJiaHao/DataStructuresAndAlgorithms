package com.obito.systemclass.class06;

import java.util.*;

/**
 * @author obito
 */
public class Code01_Comparator {

    public static class Student{
        private Integer id;
        private Integer age;
        private String name;

        public Student(Integer id, Integer age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }
    }

    public static class AgeUpComparator implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(3, 45, "A");
        Student student2 = new Student(3, 18, "B");
        Student student3 = new Student(2, 62, "C");
        Student student4 = new Student(1, 28, "D");
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.sort(new AgeUpComparator());
        for (Student student : list) {
            System.out.println(student.name);
        }
    }
}
