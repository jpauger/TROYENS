package domaine;
import javax.swing.ImageIcon;
import utilitaires.*;

/**
 *
 * @author TROYENS
 */
public class Jonction extends Equipement {
    
    
    public Jonction (Coordonnee coordonnees)
    {
        this.nom = "Jonction";
        super.coordonnees = coordonnees;
        this.image = new ImageIcon(getClass().getResource("/ico/jonction.png"));
        this.listeSorties.add(new SortieEquipement((Equipement)this, 0));  
    }
    public void calculerSortie()
    {
        this.listeSorties.get(0).listeLigneProduit = this.ObtenirListeProduitEntrant();
    }
    
}
