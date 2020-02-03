package models;


import javax.persistence.*;

@Entity
@Table(name = "stock_contenant")
public class StockContenant extends Stock implements gestionStock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
}
