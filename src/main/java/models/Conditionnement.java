package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conditionnement")
public class Conditionnement implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_plat")
    private Plat plat;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_contenant")
    private Contenant contenant;

    @ManyToOne
    @JoinColumn(name = "id_etiquette")
    private Etiquette etiquette;

    @Column(name = "prix_plat")
    private float prixPlat;

    @OneToOne(mappedBy = "conditionnementContenant")
    private CoutContenant coutContenant;

    @OneToOne(mappedBy = "conditionnementEtiquette")
    private CoutEtiquette coutEtiquette;

    /*@OneToOne(mappedBy = "conditionnementStock")
    private Stock stock;*/

    public Contenant getContenant() {
        return contenant;
    }

    public void setContenant(Contenant contenant) {
        this.contenant = contenant;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public Etiquette getEtiquette() {
        return etiquette;
    }

    public void setEtiquette(Etiquette etiquette) {
        this.etiquette = etiquette;
    }

    public float getPrixPlat() {
        return prixPlat;
    }

    public void setPrixPlat(float prixPlat) {
        this.prixPlat = prixPlat;
    }

    public CoutContenant getCoutContenant() {
        return coutContenant;
    }

    public void setCoutContenant(CoutContenant coutContenant) {
        this.coutContenant = coutContenant;
    }

    public CoutEtiquette getCoutEtiquette() {
        return coutEtiquette;
    }

    public void setCoutEtiquette(CoutEtiquette coutEtiquette) {
        this.coutEtiquette = coutEtiquette;
    }

/*    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }*/

}
