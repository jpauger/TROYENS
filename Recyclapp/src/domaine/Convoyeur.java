package domaine;
import java.awt.Color;
import utilitaires.*;



/**
 *
 * @author TROYENS
 */
public class Convoyeur {
    
    private Color couleur;
    private final SortieEquipement sortie ;
    private final Equipement equipement; 
    
    
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
    
    public void changerCouleur (Color nvlCouleur)
    {
        this.couleur = nvlCouleur ;
    }
    
    public int coorDepartX()
    {
        return this.sortie.stationMere().coordonnees.getX();
    }
    
    public int coorDepartY()
    {
        return this.sortie.stationMere().coordonnees.getY();
    }
    
   
    
    public int coorArriveeX()
    {
        return this.equipement.coordonnees.getX();
    }
    
    public int coorArriveeY()
    {
        return this.equipement.coordonnees.getX();
    }
    
}
