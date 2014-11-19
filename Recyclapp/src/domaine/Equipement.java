package domaine;
import java.awt.Dimension;
import java.util.ArrayList;
import utilitaires.*;

/**
 *
 * @author TROYENS
 */
public class Equipement {
    
    public Coordonnee coordonnees;
    public int nombreEntrees = 1 ;
    public int nombreSorties = 1 ;
    public final Dimension size = new Dimension(70,70);
    public ArrayList<SortieEquipement> listeSorties = new ArrayList();
    
    LigneProduit[] obtenirInformationTransit()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        LigneProduit[] informationTransit = null;
        return informationTransit;
    }  
    
    public boolean estSurEquipement(Coordonnee coordonnee)
    {
        int coordonneeX = coordonnee.getX();
        int coordonneeY = coordonnee.getY();
        int pointXHautGauche = this.coordonnees.getX();
        int pointXHautDroite = this.coordonnees.getX() + this.size.width;
        int pointYHautGauche = this.coordonnees.getY();
        int pointYBasGauche = this.coordonnees.getY() + this.size.height;
        
        return coordonneeX >= pointXHautGauche && coordonneeX <= pointXHautDroite && coordonneeY >= pointYHautGauche && coordonneeY <= pointYBasGauche;
    }
}
