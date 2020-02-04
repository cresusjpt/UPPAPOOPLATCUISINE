package ui;

import controllers.*;
import models.Conditionnement;
import models.Ingredient;
import models.Plat;

import java.util.List;

public class Main {

    private final static int EXECUTE_ONCE = 1;

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

            //AJOUT DES ETIQUETTE
            addEtiquette();

            //AJOUT DE QUELQUES COMPOSITIONS PLAT-INGREDIENT
            addCompositions();

            //AJOUT DE QUELQUES CONDITIONNEMENT POSSIBLE
            addConditionnementPossible();

            //AJOUT AU STOCK

        }

        //GESTION DES PLATS CUISINES
        //1 - Afficher un plat et sa composition
        System.out.println(afficher());

        //2 - Afficher pour chaque plat la liste des conditionnement possibles
        System.out.println(afficherConditionnement());

        //GESTION DE STOCKS
        //1 - Afficher le Stock des Contenant par Categorie de plat

        //GESTION FINANCIERE
        //1 - Afficher la liste des couts pour chacun des Ingrédients
        System.out.println(afficherCoutIngredient());

        //2 - Afficher pour chaque plat son Prix en fonction du conditionnement
        System.out.println(afficherPrixConditionnement());
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

    private static String afficherPrixConditionnement(){
        List<Conditionnement> conditionnements = new ConditionnementController().getAll();
        StringBuilder builder = new StringBuilder(
                "NOM DU PLAT:\tCONTENANT DU PLAT\tPRIX DU PLAT"+ "\n"
                        + "---------------------------------------------\n"
        );
        for (Conditionnement conditionnement: conditionnements) {
            builder.append(conditionnement.afficherPrixByConditionnement());
        }

        return builder.toString();
    }

    private static String afficherCoutIngredient(){
        List<Ingredient> ingredients = new IngredientController().getAll();
        StringBuilder builder = new StringBuilder(
                "UNITE INGREDIENT:\tNOM INGREDIENT\tPRIX INGREDIENT"+ "\n"
                        + "---------------------------------------------\n"
        );
        for (Ingredient ingredient: ingredients) {
            builder.append(ingredient.afficherCoutByUnite());
        }

        return builder.toString();
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

    private static void addEtiquette(){
        new EtiquetteController().bindContenantExampleData();
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
