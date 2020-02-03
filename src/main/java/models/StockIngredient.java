package models;

import javax.persistence.*;

@Entity
@Table(name = "stock_ingredient")
public class StockIngredient extends Stock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
}