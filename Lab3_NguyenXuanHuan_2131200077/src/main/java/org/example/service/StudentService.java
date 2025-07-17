package org.example.service;

import org.example.entity.Student;
import org.example.repository.StudentRepository;
import java.util.List;

public class StudentService {
    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void create(Student s) {
        repo.save(s);
    }

    public void update(Student s) {
        repo.update(s);
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
