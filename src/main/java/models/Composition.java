package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "composition")
public class Composition implements Serializable {

    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_plat")
    private Plat plat;

    @Column(name = "quantite")
    private float quantite;



    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }
}
