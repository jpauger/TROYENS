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
    public boolean estSelectionne ;
    
    
    // constructeur
    public Convoyeur (SortieEquipement uneSortie, Equipement unEquipement)
    {
        this.couleur = Color.BLUE;
        this.sortie = uneSortie ;
        this.equipement = unEquipement;
        this.estSelectionne = false ;
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
    
    // Calcul du decalage 
    
    
    private int decalageLargeurDepart(Equipement equipement)
    {
        int decalage = this.sortie.equipementMere().size.width / 2;
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
        int coorDepartX = this.sortie.equipementMere().coordonnees.getX() + decalageLargeurDepart(this.equipement) ; 
        if (this.sortie.equipementMere() instanceof Station)
        {
            coorDepartX = this.sortie.equipementMere().coordonnees.getX()+ 40 ;
        }
        return coorDepartX ;
    }
    
    public int coorDepartY()
    {
        int coorDepartY = this.sortie.equipementMere().coordonnees.getY() + decalageHauteurDepart(this.equipement);
        
        if (this.sortie.equipementMere() instanceof Station)
        {
            coorDepartY = this.sortie.equipementMere().coordonnees.getY()+ 10 + this.sortie.getNumSortie()*10 ;
        }
        return coorDepartY ;
    }
  
    public int coorArriveeX()
    {
        return this.equipement.coordonnees.getX()+ decalageLargeurArrivee(this.equipement);
    }
    
    public int coorArriveeY()
    {
        return this.equipement.coordonnees.getY()+  decalageHauteurArrivee(this.equipement);
    }
    
    public void selectionner()
    {
        this.estSelectionne = true;
        this.couleur = Color.CYAN;
    }
    
    public void deselectionner()
    {
        this.estSelectionne = false ;
        this.couleur = Color.BLUE;
    }
    
    public Color getCouleur()
    {
        return this.couleur;
    }
    
    /* Fin coordonnées */
    
}
