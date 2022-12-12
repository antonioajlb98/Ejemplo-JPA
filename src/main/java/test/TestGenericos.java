package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TestGenericos {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    public TestGenericos() {
        emf = javax.persistence.Persistence.createEntityManagerFactory("h2");
        manager = emf.createEntityManager();
    }
    public boolean insert(Object object) {
        try {
            manager.getTransaction().begin();
            manager.persist(object);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
