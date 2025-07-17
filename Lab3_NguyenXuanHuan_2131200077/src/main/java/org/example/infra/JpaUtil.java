package org.example.infra;

import jakarta.persistence.*;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("pu1-lab3");
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Initial EntityManagerFactory creation failed: " + e);
        }
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void shutdown() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
