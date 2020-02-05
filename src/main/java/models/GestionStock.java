package models;

public interface GestionStock {
    void entree(Stock stock,float quantite);
    void sortie(Stock stock, float quantite);
}
