package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "plat")
public class Plat implements Serializable {

    private static final long serialVersionUID = 11L;

    @Id
    @Column(name = "numero")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int numero;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie categorie;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.EAGER)
    //@Fetch(FetchMode.SELECT)
    @JoinTable(name = "composition",
            joinColumns = {@JoinColumn(name = "id_plat")},
            inverseJoinColumns = {@JoinColumn(name = "id_ingredient")}
    )
    private Set<Ingredient> ingredientList = new HashSet<Ingredient>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },fetch = FetchType.EAGER)
    //@Fetch(FetchMode.SELECT)
    @JoinTable(name = "conditionnement",
            joinColumns = {@JoinColumn(name = "id_plat")},
            inverseJoinColumns = {@JoinColumn(name = "id_contenant")}
    )
    private Set<Contenant> contenantList = new HashSet<Contenant>();

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setIngredientList(Set<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public Set<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public Set<Contenant> getContenantList() {
        return contenantList;
    }

    public void setContenantList(Set<Contenant> contenantList) {
        this.contenantList = contenantList;
    }

    @Override
    public String toString() {
        return "--------------------\n"
                +"AFFICHAGE DU PLAT\n"
        +"--------------------\n"
        +"Numero:\t"+ this.getNumero()+"\n"
        +"Nom:\t"+ this.getNom()+"\n"
        +"--------------------\n";
    }

    public String afficherComposition(){
        StringBuilder result = new StringBuilder(
                "COMPOSITION DU PLAT:\t" + this.getNom() + "\n"
                + "----------------------------------------------\n"
        );
        for (Ingredient ingredient: getIngredientList()) {
            result.append("Id:\t").append(ingredient.getId()).append("\n").append("Nom:\t").append(ingredient.getNom()).append("\n").append("Unite:\t").append(ingredient.getUnite()).append("\n").append("Cout:\t").append(ingredient.getCout()).append("\n");
            result.append("-----------------------\n");
        }
        return result.toString();
    }

    public String afficherContenant(){
        StringBuilder result = new StringBuilder(
                "CONDITIONNEMENTS POSSIBLE DU PLAT:\t" + this.getNom() + "\n"
                        + "----------------------------------------------\n");

        for (Contenant contenant:getContenantList()) {
            result.append(contenant.getNom()).append("\n");
            result.append("-----------------------\n");
        }

        return result.toString();
    }
}
