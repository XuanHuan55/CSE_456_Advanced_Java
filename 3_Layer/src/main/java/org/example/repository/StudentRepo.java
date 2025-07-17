package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Student;
import org.example.infra.JpaUtil;

import java.util.List;

public class StudentRepo {

    public static void saveStudent(Student student) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public static Student findById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    public static List<Student> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Student> list = em.createQuery("select s from Student s", Student.class).getResultList();
        em.close();
        return list;
    }

    public static void updateStudentById(String id, String newName, int newYob, double newGpa) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.getTransaction().begin();
            student.setName(newName);
            student.setYob(newYob);
            student.setGpa(newGpa);
            em.getTransaction().commit();
            System.out.println("Student updated: " + id);
        } else {
            System.out.println("Student does not exist");
        }
        em.close();
    }

    public static void deleteStudentById(String id) {
        EntityManager em = JpaUtil.getEntityManager();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
            System.out.println("Deleted student successfully: " + id);
        } else {
            System.out.println("Student does not exist");
        }
        em.close();
    }
}
