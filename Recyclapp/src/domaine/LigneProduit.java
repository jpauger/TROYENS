package domaine;

/**
 *
 * @author TROYENS
 */
public class LigneProduit implements java.io.Serializable {
    public Produit produit ;
    public int quantite ;

    LigneProduit(Produit produit, int quantite) {
        this.produit = produit;
        this.quantite = quantite;
    }
}
