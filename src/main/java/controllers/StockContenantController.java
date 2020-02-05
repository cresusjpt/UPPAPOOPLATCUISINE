package controllers;

import models.Conditionnement;
import models.StockContenant;
import models.StockIngredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class StockContenantController {

    public void add(StockContenant stockContenant){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(stockContenant);
        manager.getTransaction().commit();

        manager.close();
    }

    public void update(StockContenant stockContenant){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.merge(stockContenant);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<StockContenant> getAll(){
        List<StockContenant> result;
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from StockContenant t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    public void bindStockContenantDataExample(){
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();

        for (Conditionnement conditionnement: conditionnements) {
            StockContenant stockContenant = new StockContenant();
            stockContenant.setIdContenant(conditionnement.getContenant().getId());
            stockContenant.setIdPlat(conditionnement.getPlat().getNumero());
            stockContenant.setQuantite(59);
            this.add(stockContenant);
        }
    }
}
