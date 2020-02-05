package models;

import controllers.MouvementController;
import controllers.StockEtiquetteController;
import controllers.StockIngredientController;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "stock_ingredient")
public class StockIngredient extends Stock implements Serializable, GestionStock {

    private static final long serialVersionUID = 20L;

    @Id
    @Column(name = "id")
    //@GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public void entree(Stock stock, float qu) {
        Mouvement mouvement = new Mouvement();
        mouvement.setLibelle("ENTREE");
        mouvement.setStock(stock);
        mouvement.setValeur(qu);
        new MouvementController().add(mouvement);

        this.setQuantite(stock.getQuantite()+qu);
        new StockIngredientController().update(this);
    }

    public void sortie(Stock stock,float qu) {
        Mouvement mouvement = new Mouvement();
        mouvement.setLibelle("SORTIE");
        mouvement.setStock(stock);
        mouvement.setValeur(quantite);
        new MouvementController().add(mouvement);

        this.setQuantite(stock.getQuantite()-qu);
        new StockIngredientController().update(this);
    }
}