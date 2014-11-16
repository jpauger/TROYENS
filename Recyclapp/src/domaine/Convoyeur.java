package domaine;
import java.awt.Color;



/**
 *
 * @author TROYENS
 */
public class Convoyeur {
    
    Color couleur;
    SortieEquipement sortie ;
    Equipement equipement; 
    
    
    // constructeur
    public Convoyeur (SortieEquipement uneSortie, Equipement unEquipement)
    {
        this.couleur = Color.GREEN;
        this.sortie = uneSortie ;
        this.equipement = unEquipement;
    }
    
    LigneProduit[] obtenirInformationTransit()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        LigneProduit[] informationTransit = null;
        return informationTransit;
    }
    
    void changerCouleur (Color nvlCouleur)
    {
        this.couleur = nvlCouleur ;
    }
}
