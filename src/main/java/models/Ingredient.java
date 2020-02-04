package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 10L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "unite")
    private String unite;

    @Column(name = "cout")
    private float cout;

    @ManyToMany(mappedBy = "ingredientList",fetch = FetchType.EAGER)
    private List<Plat> platList;

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

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public List<Plat> getPlatList() {
        return platList;
    }

    public void setPlatList(List<Plat> platList) {
        this.platList = platList;
    }

    public String afficherCoutByUnite() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getNom())
                .append("\t")
                .append(this.getUnite())
                .append("\t")
                .append(this.getCout())
                .append("\n")
                .append("---------------------------------------------\n");

        return builder.toString();
    }
}
