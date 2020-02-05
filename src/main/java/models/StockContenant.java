package models;


import controllers.ConditionnementController;
import controllers.MouvementController;
import controllers.StockContenantController;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "stock_contenant")
public class StockContenant extends Stock implements GestionStock, Serializable {

    private static final long serialVersionUID = 15L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

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
        new MouvementController().add(mouvement);

        this.setQuantite(stock.getQuantite()+qu);
        new StockContenantController().update(this);
    }

    public void sortie(Stock stock,float qu) {
        Mouvement mouvement = new Mouvement();
        mouvement.setLibelle("SORTIE");
        mouvement.setStock(stock);
        mouvement.setValeur(quantite);
        new MouvementController().add(mouvement);

        this.setQuantite(stock.getQuantite()-qu);
        new StockContenantController().update(this);
    }

    public String afficherParCategorie(){
        StringBuilder builder = new StringBuilder();
        builder.append(

                "CONTENANT:\tCATEGORIE PLAT\tQUANTITE EN STOCK " +"\n"
        );
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();
        Conditionnement myConditionner = new Conditionnement();
        for (Conditionnement conditionnement : conditionnements) {
            if (conditionnement.getContenant().getId() == this.getIdContenant() && conditionnement.getPlat().getNumero() == this.getIdPlat())
                myConditionner = conditionnement;

        }
        builder.append(this.getId())
                .append("\t")
                .append(myConditionner.getPlat().getCategorie().getNom())
                .append("\t")
                .append(this.getQuantite())
                .append("\n")
                .append("----------------------------------------------\n");

        return builder.toString();
    }
}
