package controllers;

import models.Mouvement;
import models.Plat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class MouvementController {

    public void add(Mouvement mouvement){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(mouvement);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<Mouvement> getAll(){
        List<Mouvement> result = new ArrayList<Mouvement>();
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from Mouvement t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }
}
