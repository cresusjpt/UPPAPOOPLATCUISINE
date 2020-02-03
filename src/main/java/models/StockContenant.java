package models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock_contenant")
public class StockContenant extends Stock implements gestionStock, Serializable {

    private static final long serialVersionUID = 15L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
}
