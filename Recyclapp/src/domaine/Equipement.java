package domaine;
import utilitaires.*;
import javax.swing.JLabel;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author TROYENS
 */
public abstract class Equipement extends JLabel implements MouseListener, MouseMotionListener {
    
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
