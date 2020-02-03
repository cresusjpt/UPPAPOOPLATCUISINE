package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Stock implements Serializable {

    private static final long serialVersionUID = 9L;

    @Id
    @Column(name = "id_stock")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

/*    @OneToOne
    @JoinColumns({
            //@JoinColumn(name = "id_conditionnement"),
            @JoinColumn(name = "id_plat", insertable = false, updatable = false),
            @JoinColumn(name = "id_contenant", insertable = false, updatable = false)
    })
    protected Conditionnement conditionnementStock;*/

    @Column(name = "quantite")
    protected float quantite;

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    /*public Conditionnement getConditionnementStock() {
        return conditionnementStock;
    }

    public void setConditionnementStock(Conditionnement conditionnement) {
        this.conditionnementStock = conditionnement;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
