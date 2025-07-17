package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepo;

import java.util.List;

public class StudentService {

    public void createStudent(Student student) {
        StudentRepo.saveStudent(student);
    }

    public void updateStudent(Student student) {
        StudentRepo.updateStudentById(
                student.getId(),
                student.getName(),
                student.getYob(),
                student.getGpa()
        );
    }

    public void deleteStudent(Student student) {
        StudentRepo.deleteStudentById(student.getId());
    }

    public Student getStudentById(String id) {
        return StudentRepo.findById(id);
    }

    public List<Student> getAllStudents() {
        return StudentRepo.findAll();
    }
}
