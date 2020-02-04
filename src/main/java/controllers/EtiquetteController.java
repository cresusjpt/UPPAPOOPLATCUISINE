package controllers;

import models.Etiquette;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class EtiquetteController {

    public void add(Etiquette etiquette){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(etiquette);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<Etiquette> getAll(){
        List<Etiquette> result;
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from Etiquette t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    public void bindContenantExampleData(){
        Etiquette etiquette2 = new Etiquette();
        etiquette2.setNom(2);
        this.add(etiquette2);

        Etiquette etiquette4 = new Etiquette();
        etiquette4.setNom(4);
        this.add(etiquette4);

        Etiquette etiquette6 = new Etiquette();
        etiquette6.setNom(6);
        this.add(etiquette6);

        Etiquette etiquette8 = new Etiquette();
        etiquette8.setNom(8);
        this.add(etiquette8);

        Etiquette etiquette12 = new Etiquette();
        etiquette12.setNom(12);
        this.add(etiquette12);
    }
}
