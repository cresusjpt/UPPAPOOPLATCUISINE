package controllers;

import models.Conditionnement;
import models.StockContenant;
import models.StockEtiquette;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class StockEtiquetteController {

    public void add(StockEtiquette stockEtiquette){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(stockEtiquette);
        manager.getTransaction().commit();

        manager.close();
    }

    public void update(StockEtiquette stockEtiquette){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.merge(stockEtiquette);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<StockEtiquette> getAll(){
        List<StockEtiquette> result;
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from StockEtiquette t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    public void bindStockEtiquetteDataExample(){
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();

        for (Conditionnement conditionnement: conditionnements) {
            StockEtiquette stockEtiquette = new StockEtiquette();
            stockEtiquette.setIdContenant(conditionnement.getContenant().getId());
            stockEtiquette.setIdPlat(conditionnement.getPlat().getNumero());
            stockEtiquette.setQuantite(7);
            this.add(stockEtiquette);
        }
    }
}
