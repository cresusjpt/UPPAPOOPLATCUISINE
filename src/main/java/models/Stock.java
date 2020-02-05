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

    @Column(name = "id_contenant")
    private int idContenant;

    @Column(name = "id_plat")
    private int idPlat;

    @Column(name = "quantite")
    protected float quantite;

    @OneToOne(mappedBy = "stock")
    private Mouvement mouvement;

    public float getQuantite() {
        return quantite;
    }

    public void setQuantite(float quantite) {
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdContenant() {
        return idContenant;
    }

    public void setIdContenant(int idContenant) {
        this.idContenant = idContenant;
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }
}
