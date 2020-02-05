package controllers;

import models.Conditionnement;
import models.Plat;
import models.Stock;
import models.StockPlat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class StockPlatController {

    public void add(StockPlat stockPlat){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(stockPlat);
        manager.getTransaction().commit();

        manager.close();
    }

    public void update(StockPlat stockPlat){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.merge(stockPlat);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<StockPlat> getAll(){
        List<StockPlat> result = new ArrayList<StockPlat>();
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from StockPlat t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    public void bindStockPlatDataExample(){
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();

        for (Conditionnement conditionnement: conditionnements) {
            StockPlat stockPlat = new StockPlat();
            stockPlat.setIdContenant(conditionnement.getContenant().getId());
            stockPlat.setIdPlat(conditionnement.getPlat().getNumero());
            stockPlat.setQuantite(15);

            this.add(stockPlat);
        }
    }
}
