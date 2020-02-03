package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cout_plat")
public class CoutPlat implements Serializable {

    private static final long serialVersionUID = 7L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(name = "nombre_part")
    private int nombrePart;

    @ManyToOne
    @JoinColumn(name = "id_plat")
    private Plat plat;

    @Column(name = "cout")
    private float cout;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public int getNombrePart() {
        return nombrePart;
    }

    public void setNombrePart(int nombrePart) {
        this.nombrePart = nombrePart;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }
}
