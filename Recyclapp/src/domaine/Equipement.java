package domaine;
import java.awt.Dimension;
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
    
    LigneProduit[] obtenirInformationTransit()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        LigneProduit[] informationTransit = null;
        return informationTransit;
    }    
}
