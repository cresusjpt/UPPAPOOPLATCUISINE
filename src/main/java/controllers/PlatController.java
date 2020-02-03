package controllers;

import models.Categorie;
import models.Plat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;

public class PlatController {

    public void add(Plat plat){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(plat);
        manager.getTransaction().commit();

        manager.close();
    }

    public void bindPlatsDataExample(){
        //INSERT CATEGORIE TAJINE PLAT (la categorie tajine est 1 dans notre exemple
        Categorie categorie = new Categorie();
        categorie.setId(1);
        for (String value : getTajineExampleList()) {
            Plat plat = new Plat();
            plat.setNom(value);
            plat.setCategorie(categorie);
            this.add(plat);
        }

        //INSERT CATEGORIE COUSCOUS PLAT (la categorie couscous est 2 dans notre exemple
        Categorie categorie2 = new Categorie();
        categorie2.setId(2);
        for (String value : getCouscousExampleList()) {
            Plat plat = new Plat();
            plat.setNom(value);
            plat.setCategorie(categorie2);
            this.add(plat);
        }

        //INSERT CATEGORIE CASSOLETTES PLAT (la categorie couscous est 3 dans notre exemple
        Categorie categorie3 = new Categorie();
        categorie3.setId(3);
        for (String value : getCassoletteExampleList()) {
            Plat plat = new Plat();
            plat.setNom(value);
            plat.setCategorie(categorie3);
            this.add(plat);
        }
    }

    private List<String> getTajineExampleList(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("Tagine d'agneau aux aubergines");
        stringList.add("Tagine d'agneau aux dattes");
        stringList.add("Tagine d'agneau aux pommes de terre");
        stringList.add("Tagine d'Agadir au grondin");
        stringList.add("Tagine de bœuf et poivrons");
        stringList.add("Tagine de kefta aux œufs");
        return stringList;
    }

    private List<String> getCouscousExampleList(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("Couscous Togolais");
        stringList.add("Couscous Royal");
        stringList.add("Couscous Merguez");
        stringList.add("Couscous Maroccain");
        return stringList;
    }

    private List<String> getCassoletteExampleList(){
        List<String> stringList = new ArrayList<String>();
        stringList.add("Cassolettes de Saint-Jacques");
        stringList.add("Cassolettes fruits de mer beurre citronné");
        stringList.add("Cassolettes légumes");
        stringList.add("Cassolettes aux homards");
        return stringList;
    }


}
