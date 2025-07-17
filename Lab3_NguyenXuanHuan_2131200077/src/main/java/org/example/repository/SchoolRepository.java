package org.example.repository;

import jakarta.persistence.*;
import org.example.entity.School;
import java.util.List;

public class SchoolRepository {
    private EntityManager em;

    public SchoolRepository(EntityManager em) {
        this.em = em;
    }

    public boolean existsById(String id) {
        return em.find(School.class, id) != null;
    }


    public void save(School school) {

        if (existsById(school.getSchoolId())) {
            System.out.println(" School ID " + school.getSchoolId() + " existed.");
            return;
        }
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
    }

    public void update(School school) {
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
    }

    public School findById(String id) {
        return em.find(School.class, id);
    }

    public List<School> findAll() {
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    public void delete(String id) {
        School s = findById(id);
        if (s != null) {
            em.getTransaction().begin();
            em.remove(s);
            em.getTransaction().commit();
        }
    }
}
