package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.Major;
import org.example.entity.School;

import java.util.List;

public class MajorRepository {
    private EntityManager em;

    public MajorRepository(EntityManager em) {
        this.em = em;
    }

    public boolean existsById(String id) {
        return em.find(Major.class, id) != null;
    }

    public void save(Major major) {
        if (existsById(major.getMajorId())) {
            System.out.println(" Major ID " + major.getMajorId() + " existed.");
            return;
        }
        em.getTransaction().begin();
        em.persist(major);
        em.getTransaction().commit();
    }

    public void update(Major major) {
        em.getTransaction().begin();
        em.merge(major);
        em.getTransaction().commit();
    }

    public Major findById(String id) {
        return em.find(Major.class, id);
    }

    public List<Major> findAll() {
        return em.createQuery("SELECT m FROM Major m", Major.class).getResultList();
    }

    public void delete(String id) {
        Major m = findById(id);
        if (m != null) {
            em.getTransaction().begin();
            em.remove(m);
            em.getTransaction().commit();
        }
    }
}
