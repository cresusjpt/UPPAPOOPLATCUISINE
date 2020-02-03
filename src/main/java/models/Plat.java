package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plat")
public class Plat implements Serializable {

    private static final long serialVersionUID = 11L;

    @Id
    @Column(name = "numero")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "composition",
            joinColumns = {@JoinColumn(name = "id_plat")},
            inverseJoinColumns = {@JoinColumn(name = "id_ingredient")}
    )
    private Set<Ingredient> ingredientList = new HashSet<Ingredient>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "conditionnement",
            joinColumns = {@JoinColumn(name = "id_plat")},
            inverseJoinColumns = {@JoinColumn(name = "id_contenant")}
    )
    private Set<Contenant> contenantList = new HashSet<Contenant>();

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
}
