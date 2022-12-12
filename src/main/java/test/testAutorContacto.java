package test;

import model.Autor;
import model.Contacto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class testAutorContacto {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    public static void main(String[] args) {
        emf = javax.persistence.Persistence.createEntityManagerFactory("h2");
        manager = emf.createEntityManager();

        Autor autor = new Autor(1, "João");
        Contacto contacto = new Contacto(1L, "c@gmail.com", "001215");
        autor.setContacto(contacto);
        manager.getTransaction().begin();
        manager.persist(autor);
        manager.getTransaction().commit();
        list();
        manager.close();

    }
    public static void list() {
        List<Autor> autores = manager.createQuery("select a from Autor a").getResultList();
        System.out.println(autores);
    }
}
