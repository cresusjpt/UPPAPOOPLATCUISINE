package models;

import controllers.ConditionnementController;
import controllers.MouvementController;
import controllers.StockPlatController;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "stock_plat")
public class StockPlat extends Stock implements Serializable, GestionStock {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    private static final long serialVersionUID = 47L;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public void entree(Stock stock, float qu) {
        Mouvement mouvement = new Mouvement();
        mouvement.setLibelle("ENTREE");
        mouvement.setStock(stock);
        mouvement.setValeur(qu);

        this.setQuantite(stock.getQuantite()+qu);
        new StockPlatController().update(this);
    }

    public void sortie(Stock stock,float qu) {
        Mouvement mouvement = new Mouvement();
        mouvement.setLibelle("SORTIE");
        mouvement.setStock(stock);
        mouvement.setValeur(quantite);
        new MouvementController().add(mouvement);

        this.setQuantite(stock.getQuantite()-qu);
        new StockPlatController().update(this);
    }

    public String afficherParConditionnement(){
        StringBuilder builder = new StringBuilder();
        builder.append(

                "PLAT:\tCONDITIONNEMENT PLAT\tQUANTITE EN STOCK " +"\n"
        );
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();
        Conditionnement myConditionner = new Conditionnement();
        for (Conditionnement conditionnement : conditionnements) {
            if (conditionnement.getContenant().getId() == this.getIdContenant() && conditionnement.getPlat().getNumero() == this.getIdPlat())
                myConditionner = conditionnement;

        }
        builder.append(this.getId())
                .append("\t")
                .append(myConditionner.getContenant().getNom())
                .append("\t")
                .append(this.getQuantite())
                .append("\n").append("----------------------------------------------\n");

        return builder.toString();
    }
}
