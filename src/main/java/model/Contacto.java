package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "CONTACTO")
public class Contacto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    Long id;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "PHONE")
    String phone;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "ID_AUTOR")
    private Autor autor;

    public Contacto() {
        this(-1L,"","");
    }

    public Contacto(Long id, String email, String phone) {
        this.id = id;
        this.email = email;
        this.phone = phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacto contacto = (Contacto) o;
        return Objects.equals(id, contacto.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", autor=" + autor +
                '}';
    }
}
