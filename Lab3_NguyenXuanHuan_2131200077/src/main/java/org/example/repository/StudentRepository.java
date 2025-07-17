package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.Student;
import java.util.List;

public class StudentRepository {
    private EntityManager em;

    public StudentRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    public void update(Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    public void delete(int id) {
        Student s = findById(id);
        if (s != null) {
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        }
    }
}
