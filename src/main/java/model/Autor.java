package model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "AUTOR")
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
    private String name;
    @OneToOne(mappedBy = "autor", cascade = CascadeType.ALL)
    private Contacto contacto;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;


    public Autor() {
    }

    public Autor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public void setLibros(List<Libro> libros) {
        if(libros == null) return;
        for(Libro libro : libros) {
            this.addLibro(libro);
        }

    }
    public void addLibro(Libro libro) {
        if(libro==null) return;
        if(this.libros == null) this.libros = new ArrayList<Libro>();
        if(this.libros.contains(libro)) {
            libro.setAutor(this);
            this.libros.add(libro);
        }

    }


    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contacto=" + contacto +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id == autor.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
