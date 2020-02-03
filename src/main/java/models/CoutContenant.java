package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cout_contenant")
public class CoutContenant implements Serializable {

    private static final long serialVersionUID = 5L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "cout")
    private float cout;

    @OneToOne
    @JoinColumns({
            //@JoinColumn(name = "id_conditionnement"),
            @JoinColumn(name="id_plat"),
            @JoinColumn(name="id_contenant")
    })
    private Conditionnement conditionnementContenant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getCout() {
        return cout;
    }

    public void setCout(float cout) {
        this.cout = cout;
    }

    public Conditionnement getConditionnementContenant() {
        return conditionnementContenant;
    }

    public void setConditionnementContenant(Conditionnement conditionnementContenant) {
        this.conditionnementContenant = conditionnementContenant;
    }
}
