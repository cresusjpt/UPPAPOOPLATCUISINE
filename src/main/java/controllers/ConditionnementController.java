package controllers;

import models.Conditionnement;
import models.Contenant;
import models.Plat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ConditionnementController {

    public void add(Conditionnement conditionnement){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(conditionnement);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<Conditionnement> getAll(){
        List<Conditionnement> result;
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from Conditionnement t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }
    
    public void bindConditionnement(){
        List<Plat> plats = new PlatController().getAll();
        List<Contenant> contenants = new ContenantController().getAll();

        for (int i = 0; i < plats.size(); i++) {
            Plat plat = plats.get(i);
            for (int j = 0; j < contenants.size(); j++) {
                Contenant contenant = contenants.get(j);
                Conditionnement conditionnement = new Conditionnement();

                //un petit jeu de test pour ne pas rendre possible tout les conditionnement pour les plats
                if (plat.getNumero() >=9 && plat.getNumero() <= 13 && contenant.getNom()>2 ){
                    conditionnement.setContenant(contenant);
                    conditionnement.setPlat(plat);
                    conditionnement.setPrixPlat(5);
                }else {
                    conditionnement.setContenant(contenant);
                    conditionnement.setPlat(plat);
                    conditionnement.setPrixPlat(10);
                }
                this.add(conditionnement);
            }
        }
    }
}
