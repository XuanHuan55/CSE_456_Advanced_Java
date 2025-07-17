package org.example.infra;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    private static final EntityManagerFactory emf;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("PU1-student-3-layer");
        } catch(Exception e){
            System.out.println("cannt create entity PU1-student-3-layer");
            throw new RuntimeException(e);
        }
    }
    private JpaUtil(){

    }

    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
