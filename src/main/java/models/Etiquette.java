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
    private int nom;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNom() {
        return nom;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }
}
