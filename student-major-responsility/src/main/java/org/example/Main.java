package org.example;

import jakarta.persistence.EntityManager;
import org.example.service.StudentService;
import org.example.entity.Student;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        StudentService studentService = new StudentService();
//        studentService.createStudent(s1);
//        studentService.createStudent(s2);
//        studentService.createStudent(s3);
//        studentService.createStudent(s4);

        List<Student> studentList = studentService.getAllStudents();
        System.out.println("Danh sách sinh viên:");
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
