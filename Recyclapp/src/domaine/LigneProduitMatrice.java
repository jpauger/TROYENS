package domaine;

/**
 *
 * @author TROYENS
 */
public class LigneProduitMatrice implements java.io.Serializable {
    
    int pourcentage ;
    SortieEquipement sortieEquipement;

    LigneProduitMatrice(int pourcentage, SortieEquipement sortie) {
        this.pourcentage = pourcentage;
        this.sortieEquipement = sortie;
    }
}
