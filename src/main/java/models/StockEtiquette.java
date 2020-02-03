package models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock_etiquette")
public class StockEtiquette extends Stock implements Serializable,gestionStock {

    private static final long serialVersionUID = 16L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
}
