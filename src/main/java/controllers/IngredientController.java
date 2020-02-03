package controllers;

import models.Ingredient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class IngredientController {

    public void add(Ingredient ingredient){
        EntityManagerFactory factory = utils.EntityManagerFactory.getInstance();

        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();

        manager.persist(ingredient);
        manager.getTransaction().commit();

        manager.close();
    }

    public void bindIngredientsDataExample(){
        String[] ingredientName = {"Fromage rapé","Aubergine","Courgette","Poivron","Carrotes","Pomme de terre","Riz","Abricots","Noix","Prunueax","Oeuf","Oignons","Tomate","Citron","Huile d'olive"};
        String[] ingredientUnite = {"Kg","Kg","Kg","Kg","Kg","Kg","Kg","Kg","Kg","Kg","U","U","U","U","L"};
        float[] ingredientPrice = {5,2,1,2,1,0.5f,0.5f,6,10,5,0.2f,0.1f,0.4f,0.3f,6};

        for (int i = 0; i < ingredientName.length; i++) {
            Ingredient ingredient = new Ingredient();
            ingredient.setNom(ingredientName[i]);
            ingredient.setUnite(ingredientUnite[i]);
            ingredient.setCout(ingredientPrice[i]);

            this.add(ingredient);
        }
    }
}
