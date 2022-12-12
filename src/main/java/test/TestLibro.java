package test;

import model.Autor;
import model.Contacto;
import model.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class TestLibro {
    private static EntityManager manager;
    private static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf=javax.persistence.Persistence.createEntityManagerFactory("h2");
        manager=emf.createEntityManager();

        Autor autor = new Autor(1,"João");
        Contacto contacto = new Contacto(1L,"@paco123","123456789");
        Libro libro = new Libro("Java","JPA");
        manager.getTransaction().begin();

        manager.getTransaction().commit();
    }
}
