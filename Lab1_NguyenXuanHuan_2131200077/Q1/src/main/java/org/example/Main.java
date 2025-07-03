package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Tạo Student
        Student student = Student.builder()
                .id("S001")
                .firstName("Nguyen")
                .lastName("An")
                .yearOfBirth(2002)
                .gpa(3.75)
                .build();


        // Tạo Course
        Course course = Course.builder()
                .idCourse("C101")
                .name("Advanced Java")
                .credits(3)
                .hours(45.5)
                .build();

        //toString()
        System.out.println("=== Student toString ===");
        System.out.println(student.toString());
        System.out.println(course.toString());

        System.out.println("___________________");
        //JSON
        String jsonStudent = mapper.writeValueAsString(student);
        String jsonCourse = mapper.writeValueAsString(course);

        System.out.println("=== Student JSON ===");
        System.out.println(jsonStudent);
        System.out.println(jsonCourse);
    }
}
