package org.example;

import jakarta.persistence.EntityManager;
import org.example.entity.Major;
import org.example.entity.School;
import org.example.entity.Student;
import org.example.entity.Student.Gender;
import org.example.infra.JpaUtil;
import org.example.repository.MajorRepository;
import org.example.repository.SchoolRepository;
import org.example.repository.StudentRepository;
import org.example.service.MajorService;
import org.example.service.SchoolService;
import org.example.service.StudentService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = JpaUtil.getEntityManager();

        SchoolService schoolService = new SchoolService(new SchoolRepository(em));
        MajorService majorService = new MajorService(new MajorRepository(em));
        StudentService studentService = new StudentService(new StudentRepository(em));

        // Tạo mới school và major
        School school = new School("CSE", "Computer Science and Engineering", "EIU");
        schoolService.create(school);

        Major major = new Major("SE01", "Software Engineering", school);
        majorService.create(major);

        // Tạo mới student
        Student s1 = new Student("Nguyen Van A", Gender.Male, LocalDate.of(2003, 10, 5), 3.75, 2021, school, major);
        Student s2 = new Student("Nguyen Van B", Gender.Female, LocalDate.of(2003, 11, 5), 3.25, 2023, school, major);
        studentService.create(s1);
        studentService.create(s2);

        // In danh sách sinh viên
        System.out.println("\n--- All Students ---");
        for (Student s : studentService.getAll()) {
            System.out.println(s.getStudentId() + " - " + s.getFullName() + " - " + s.getMajor().getMajorName());
        }

        // Update GPA sinh viên
        System.out.println("\n--- UPDATE Student GPA ---");
        Student updatedStudent = studentService.getAll().get(0);
        updatedStudent.setGpa(3.95);
        studentService.update(updatedStudent);
        System.out.println("Updated GPA: " + updatedStudent.getGpa());

        // Update Major Name
        System.out.println("\n--- UPDATE Major ---");
        Major updatedMajor = majorService.getAll().get(0);
        updatedMajor.setMajorName("Updated Software Engineering");
        majorService.update(updatedMajor);
        System.out.println("Updated Major Name: " + updatedMajor.getMajorName());

        // Update School Name
        System.out.println("\n--- UPDATE School ---");
        School updatedSchool = schoolService.getAll().get(0);
        updatedSchool.setSchoolName("Updated CSE School");
        schoolService.update(updatedSchool);
        System.out.println("Updated School Name: " + updatedSchool.getSchoolName());

        // Delete Student
        System.out.println("\n--- DELETE Student ---");
        int idToDelete = studentService.getAll().get(1).getStudentId();
        studentService.delete(idToDelete);
        System.out.println("Remaining students: " + studentService.getAll().size());

        // Delete Major
        System.out.println("\n--- DELETE Major ---");
        majorService.delete(updatedMajor.getMajorId());
        System.out.println("Remaining majors: " + majorService.getAll().size());

        // Delete School
        System.out.println("\n--- DELETE School ---");
        schoolService.delete(updatedSchool.getSchoolId());
        System.out.println("Remaining schools: " + schoolService.getAll().size());

        em.close();
        JpaUtil.shutdown();
    }
}
