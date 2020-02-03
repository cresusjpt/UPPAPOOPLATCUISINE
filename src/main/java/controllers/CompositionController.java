package controllers;

import models.Composition;
import models.Ingredient;
import models.Plat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CompositionController {
    public void add(Composition composition){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(composition);
        manager.getTransaction().commit();

        manager.close();
    }

    public void bindCompositionDataExample(){
        List<Plat> plats = new PlatController().getAll();
        List<Ingredient> ingredients = new IngredientController().getAll();

        for (Plat plat :plats) {
            for(Ingredient ingredient:ingredients) {
                Composition composition = new Composition();
                composition.setPlat(plat);
                composition.setIngredient(ingredient);
                composition.setQuantite(1.5f);

                this.add(composition);
            }
        }

    }
}
