package ui;

import controllers.CategorieController;
import controllers.IngredientController;
import controllers.PlatController;

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
        }

        //1 - Afficher un plat et sa composition
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
}
