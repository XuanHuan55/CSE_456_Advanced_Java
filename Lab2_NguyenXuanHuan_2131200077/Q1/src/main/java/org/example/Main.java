package org.example;

import jakarta.persistence.*;
import org.example.Entity.Student;

import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu1-mysql-masterapp");

    public static void main(String[] args) {
       // insertStudent();
      // getStudentById("S001");
      //  getAllStudents();
 //       updateStudentById("S001", "Nguyen Van G", 1999, 3.8);
       deleteStudentById("S001");

        emf.close();
    }

    // insert
    public static void insertStudent() {
        EntityManager em = emf.createEntityManager();
        Student s1 = new Student("S003", "Nguyen Van C", 2003, 3.2);
        Student s2 = new Student("S002", "Nguyen Van B", 2002, 4.0);
        em.getTransaction().begin();
        em.persist(s1);
        em.persist(s2);
        em.getTransaction().commit();

        em.close();
        System.out.println("Insert done!");
    }

    // findById
    public static void getStudentById(String id) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);
        if (student != null) {
            System.out.println("Student found" + student);
        } else {
            System.out.println("Dont find student: " + id);
        }

        em.close();
    }

    // getAllStudent
    public static void getAllStudents() {
        EntityManager em = emf.createEntityManager();

        List<Student> list = em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
        System.out.println("Student list:");
        list.forEach(System.out::println);

        em.close();
    }

    // UpdateStudentByID
    public static void updateStudentById(String id, String newName, int newYob, double newGpa) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);
        if (student != null) {
            em.getTransaction().begin();
            student.setName(newName);
            student.setYob(newYob);
            student.setGpa(newGpa);
            em.getTransaction().commit();
            System.out.println("Student updated: " + id);
        } else {
            System.out.println("Student doesnot exist");
        }

        em.close();
    }

    // DeleteStudentByID
    public static void deleteStudentById(String id) {
        EntityManager em = emf.createEntityManager();

        Student student = em.find(Student.class, id);
        if (student != null) {
            em.getTransaction().begin();
            em.remove(student);
            em.getTransaction().commit();
            System.out.println("Deleted student successfully: " + id);
        } else {
            System.out.println("Student doesnot exist");
        }

        em.close();
    }
}
