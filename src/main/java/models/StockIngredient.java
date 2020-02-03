package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock_ingredient")
public class StockIngredient extends Stock implements Serializable, GestionStock {

    private static final long serialVersionUID = 20L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
}