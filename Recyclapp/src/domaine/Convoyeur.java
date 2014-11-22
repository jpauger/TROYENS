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
    
    
    // Calcul du decalage 
    
    
    private int decalageLargeurDepart(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.width / 2;
        if (this.sortie.equipementMere() instanceof Jonction){ decalage -= 20 ;}
        return decalage;
    }
    
    private int decalageHauteurDepart(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.height / 2;
        return decalage;
    }
    
    private int decalageLargeurArrivee (Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.width / 2;
        if (this.equipement instanceof Jonction){ decalage -= 20 ;}
        return decalage;
    }
    
    private int decalageHauteurArrivee(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.height / 2;
        return decalage;
    }
    
    
    
    /* les coorDepart donnnent pour un convoyeur les coordonnées de départ utilisées pour sa représentation graphique */
    public int coorDepartX()
    {
        return this.sortie.equipementMere().coordonnees.getX() + decalageLargeurDepart(this.equipement) ;
    }
    
    public int coorDepartY()
    {
        return this.sortie.equipementMere().coordonnees.getY() + decalageHauteurDepart(this.equipement);
    }
  
    public int coorArriveeX()
    {
        return this.equipement.coordonnees.getX()+ decalageLargeurArrivee(this.equipement);
    }
    
    public int coorArriveeY()
    {
        return this.equipement.coordonnees.getY()+  decalageHauteurArrivee(this.equipement);
    }
    
    /* Fin coordonnées */
    
}
