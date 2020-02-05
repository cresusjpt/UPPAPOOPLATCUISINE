package controllers;

import models.Conditionnement;
import models.Ingredient;
import models.StockIngredient;
import models.StockPlat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockIngredientController {

    public void add(StockIngredient stockIngredient){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(stockIngredient);
        manager.getTransaction().commit();

        manager.close();
    }

    public void update(StockIngredient stockIngredient){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.merge(stockIngredient);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<StockIngredient> getAll(){
        List<StockIngredient> result = new ArrayList<StockIngredient>();
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from StockIngredient t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    public void bindStockIngredientDataExample(){
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();

        for (Conditionnement conditionnement: conditionnements) {
            StockIngredient stockIngredient = new StockIngredient();
            stockIngredient.setIdContenant(conditionnement.getContenant().getId());
            stockIngredient.setIdPlat(conditionnement.getPlat().getNumero());
            stockIngredient.setQuantite(26);
            this.add(stockIngredient);
        }
    }
}
