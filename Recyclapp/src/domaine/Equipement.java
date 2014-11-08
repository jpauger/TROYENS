package domaine;
import utilitaires.*;

/**
 *
 * @author TROYENS
 */
public abstract class Equipement {
    
    Coordonnee coordonnees;
    int nombreEntrees = 1 ;
    int nombreSorties = 1 ;
    
    LigneProduit[] obtenirInformationTransit()
    {
        //code temporaire juste pour eviter une erreur de type "missing return"
        LigneProduit[] informationTransit = null;
        return informationTransit;
    }
    
}
