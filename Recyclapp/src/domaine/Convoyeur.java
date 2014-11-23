package domaine;
import java.awt.Color;


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
        unEquipement.sortieEntrante = uneSortie;
        if(unEquipement instanceof Station)
            ((Station)unEquipement).definirMatriceBase();
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
    
    /* les coorDepart donnnent pour un convoyeur les coordonnées de départ utilisées pour sa représentation graphique */
    public int coorDepartX()
    {
        return this.sortie.equipementMere().coordonnees.getX() + (this.sortie.equipementMere().size.width / 2);
    }
    
    public int coorDepartY()
    {
        return this.sortie.equipementMere().coordonnees.getY() + (this.sortie.equipementMere().size.height / 2);
    }
  
    public int coorArriveeX()
    {
        return this.equipement.coordonnees.getX()+ (this.sortie.equipementMere().size.width / 2);
    }
    
    public int coorArriveeY()
    {
        return this.equipement.coordonnees.getY()+ (this.sortie.equipementMere().size.height / 2);
    }
    
    /* Fin coordonnées */
    
}
