package controllers;

import models.Categorie;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class CategorieController {

    public static final String TAJINE = "Tajines";
    public static final String COUSCOUS = "Couscous";
    public static final String CASSOLETTES = "Cassolettes";
    public static final String[] noms = {TAJINE,COUSCOUS,CASSOLETTES};

    public void add(Categorie categorie){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(categorie);
        manager.getTransaction().commit();
        manager.close();
    }

    public Categorie find(Categorie categorie){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        Categorie cate = manager.find(Categorie.class,1);

        manager.close();

        return cate;
    }

    public void delete(Categorie categorie){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(categorie);

        manager.close();
    }

    public void bindCategorieDataExample(){
        for (int i = 0; i < 3; i++) {
            Categorie categorie = new Categorie();
            categorie.setNom(noms[i]);
            this.add(categorie);
        }
    }


}
