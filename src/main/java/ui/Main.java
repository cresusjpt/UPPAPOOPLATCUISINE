package ui;

import controllers.*;
import models.*;

import java.util.List;

public class Main {

    //cette variable nous permet d'executer les codes qui nous permettent d'ajouter les données qu'une seule fois
    //apres une premiere execution il faudra la chager en 2 ou un autre chiffre different de 1
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
            addStockPlat();
            addStockIngredient();
            addStockContenant();
            addStockEtiquette();

            //EFFECTUONS UNE SORTIE SUR CHAQQUE STOCK
            sortieStocks();
        }

        //GESTION DES PLATS CUISINES
        //1 - Afficher un plat et sa composition
        System.out.println(afficher());

        //2 - Afficher pour chaque plat la liste des conditionnement possibles
        System.out.println(afficherConditionnement());

        //GESTION DE STOCKS
        //1 - Afficher le Stock des Contenants par Categorie de plat
        System.out.println(afficherStockContenantByCategorie());

        //2 - Afficher le Stock des Etiquette par plat
        System.out.println(afficherStockEtiquetteByPlat());

        //3 - Afficher le Stock des Plats par Conditionnement
        System.out.println(afficherStockPlatByConditionnement());

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

    private static void addStockPlat(){
        new StockPlatController().bindStockPlatDataExample();
    }

    private static void addStockIngredient(){
        new StockIngredientController().bindStockIngredientDataExample();
    }

    private static void addStockContenant(){
        new StockContenantController().bindStockContenantDataExample();
    }

    private static void addStockEtiquette(){
        new StockEtiquetteController().bindStockEtiquetteDataExample();
    }

    private static void sortieStocks(){
        List<StockPlat> stockPlats = new StockPlatController().getAll();
        List<StockIngredient> stockIngredients = new StockIngredientController().getAll();
        List<StockContenant> stockContenants = new StockContenantController().getAll();
        List<StockEtiquette> stockEtiquettes = new StockEtiquetteController().getAll();

        for (StockPlat st : stockPlats) {
            st.sortie(st,1);
        }

        for (StockContenant st : stockContenants) {
            st.sortie(st,1);
        }

        for (StockEtiquette st : stockEtiquettes) {
            st.sortie(st,1);
        }
    }

    private static String afficherStockContenantByCategorie(){
        StringBuilder string = new StringBuilder();
        List<StockContenant> stockContenants = new StockContenantController().getAll();

        for (StockContenant stockContenant: stockContenants) {
            string.append(stockContenant.afficherParCategorie());
        }
        return string.toString();
    }

    private static String afficherStockEtiquetteByPlat(){
        StringBuilder string = new StringBuilder();
        List<StockEtiquette> stockEtiquettes = new StockEtiquetteController().getAll();

        for (StockEtiquette st: stockEtiquettes) {
            string.append(st.afficherParPlat());
        }
        return string.toString();
    }

    private static String afficherStockPlatByConditionnement(){
        StringBuilder string = new StringBuilder();
        List<StockPlat> stockPlats = new StockPlatController().getAll();

        for (StockPlat st: stockPlats) {
            string.append(st.afficherParConditionnement());
        }
        return string.toString();
    }
}
