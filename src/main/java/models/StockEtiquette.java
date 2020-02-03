package models;

import javax.persistence.*;

@Entity
@Table(name = "stock_etiquette")
public class StockEtiquette extends Stock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
}
