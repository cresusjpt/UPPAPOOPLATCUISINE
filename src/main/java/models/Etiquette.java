package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "etiquette")
public class Etiquette implements Serializable {

    private static final long serialVersionUID = 8L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
