package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cout_etiquette")
public class CoutEtiquette implements Serializable {

    private static final long serialVersionUID = 6L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "prix")
    private float prix;

    @OneToOne
    @JoinColumns({
            //@JoinColumn(name = "id_conditionnement"),
            @JoinColumn(name="id_plat"),
            @JoinColumn(name="id_contenant")
    })
    private Conditionnement conditionnementEtiquette;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
