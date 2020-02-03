package controllers;

import models.Contenant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ContenantController {

    public void add(Contenant contenant){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(contenant);
        manager.getTransaction().commit();

        manager.close();
    }

    public List<Contenant> getAll(){
        List<Contenant> result;
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        result =  manager.createQuery("select t from Contenant t").getResultList();

        manager.getTransaction().commit();
        manager.close();

        return result;
    }

    public void bindContenantExampleData(){
        Contenant contenant2 = new Contenant();
        contenant2.setNom(2);
        this.add(contenant2);

        Contenant contenant4 = new Contenant();
        contenant4.setNom(4);
        this.add(contenant4);

        Contenant contenant6 = new Contenant();
        contenant6.setNom(6);
        this.add(contenant6);

        Contenant contenant8 = new Contenant();
        contenant8.setNom(8);
        this.add(contenant8);

        Contenant contenant12 = new Contenant();
        contenant12.setNom(12);
        this.add(contenant12);
    }
}
