package ui;

import controllers.*;
import models.Plat;

import java.util.List;

public class Main {

    private final static int EXECUTE_ONCE = 2;

    public static void main(String[] args) {

        if (EXECUTE_ONCE == 1) {
            //AJOUT DES CATEGORIE DE PLATS
            addCategories();

            //AJOUT DE QUELQUES PLATS
            addPlats();

            //AJOUT DE QUELQUES INGREDIENTS
            addIngredients();

            //AJOUT DES CONTENANTS
            addContenant();

            //AJOUT DE QUELQUES COMPOSITIONS PLAT-INGREDIENT
            addCompositions();

            //AJOUT DE QUELQUES CONDITIONNEMENT POSSIBLE
            addConditionnementPossible();
        }

        //GESTION DES PLATS CUISINES
        //1 - Afficher un plat et sa composition
        System.out.println(afficher());

        //2 - Afficher pour chaque plat la liste des conditionnement possibles
        System.out.println(afficherConditionnement());

        //GESTION FINANCIERE
        //1 - Afficher la liste des couts pour chacun des Ingrédients

        //2 - Afficher pour chaque plat son Prix en fonction du conditionnement
    }

    private static String afficher(){
        StringBuilder result = new StringBuilder();
        PlatController controller = new PlatController();
        List<Plat> plats = controller.getAll();

        for (Plat value :plats) {
            result.append(value.toString());
            result.append(value.afficherComposition());
        }
        return result.toString();
    }

    private static String afficherConditionnement(){
        StringBuilder result = new StringBuilder();
        for (Plat plat :new PlatController().getAll()) {
            result.append(plat.afficherContenant());
        }
        return result.toString();
    }


    private static void addCategories() {
        System.out.println("Ajout de ctegorie");
        CategorieController categorieController = new CategorieController();
        categorieController.bindCategorieDataExample();
    }

    private static void addPlats() {
        PlatController controller = new PlatController();
        controller.bindPlatsDataExample();
    }

    private static void addIngredients() {
        IngredientController controller = new IngredientController();
        controller.bindIngredientsDataExample();
    }

    private static void addContenant() {
        ContenantController controller = new ContenantController();
        controller.bindContenantExampleData();
    }

    private static void addCompositions(){
        CompositionController controller = new CompositionController();
        controller.bindCompositionDataExample();
    }

    private static void addConditionnementPossible(){
        ConditionnementController conditionnementController = new ConditionnementController();
        conditionnementController.bindConditionnement();
    }
}
