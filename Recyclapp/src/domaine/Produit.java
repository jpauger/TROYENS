package domaine;

/**
 *
 * @author TROYENS
 */
public class Produit implements java.io.Serializable {    
    public String nom ;
    public String description ;

    public Produit(String nom) {
        this.nom = nom;
    }
}
