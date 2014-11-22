package domaine;

/**
 *
 * @author TROYENS
 */
public class LigneProduitMatrice {
    
    Produit produit ;
    int pourcentage ;
    SortieEquipement sortieEquipement;

    LigneProduitMatrice(Produit produit, int pourcentage, SortieEquipement sortie) {
       this.produit = produit;
        this.pourcentage = pourcentage;
        this.sortieEquipement = sortie;
    }
}
