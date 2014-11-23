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
        super.coordonnees = coordonnees;
        this.image = new ImageIcon("src/ico/jonction.png");
        this.listeSorties.add(new SortieEquipement((Equipement)this, 0));  
    }
    
}
