package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "contenant")
public class Contenant implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private int nom;

    @ManyToMany(mappedBy = "contenantList")
    private List<Plat> platList;

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
