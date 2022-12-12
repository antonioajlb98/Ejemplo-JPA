package test;

import model.Autor;
import model.Libro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class testAutor {
    private static EntityManager manager;
    private static EntityManagerFactory emf;
    private static TestGenericos testGenericos = new TestGenericos();
    public static void main(String[] args) {
        emf = javax.persistence.Persistence.createEntityManagerFactory("h2");
        manager = emf.createEntityManager();
        Autor autor = new Autor(1, "João");
        Libro libro = new Libro("Java", "JPA");
        testGenericos.insert(autor);
        testGenericos.insert(libro);
        List<Autor> autores = manager.createQuery("select a from Autor a").getResultList();
        System.out.println(autores);
    }
}
